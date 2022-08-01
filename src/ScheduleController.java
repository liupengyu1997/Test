import com.jd.jim.common.utils.Page;
import com.jd.jimdb.common.util.Args;
import com.jd.jimdb.export.constants.ReturnCode;
import com.jd.jimdb.export.domain.TaskResponse;
import com.jd.jimdb.model.model.TaskResult;
import com.jd.jimdb.model.service.TaskCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ScheduleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    @Inject
    private TaskCommonService taskCommonService;

    @Inject
    private JScheduleService jScheduleService;

    @CrossOrigin(origins = "*")
    @PostMapping("/task/createTask")
    @ResponseBody
    public TaskResponse create(@RequestParam String type, @RequestParam String businessId,
                                     @RequestParam String payload, @RequestParam String by) {
        LOGGER.info("call /task/create , type={},businessId={},payload={},sign={},d={}",
                type, businessId, payload);
        TaskResponse response = new TaskResponse(ReturnCode.ACTIVE_FAILURE);
        try {
            //   校验参数
            Args.notNull(type, "type");
            Args.notNull(businessId, "businessId");
            Args.notNull(payload, "payload");
            Args.notNull(by, "by");

            // 创建apply，同时创建 schedule
            long scheduleId = taskCommonService.createTask(type,businessId, payload,by);
            LOGGER.info("/task/create , type:{},payload:{},scheduleId:{}", type, payload,
                    scheduleId);
            response.setAttach(scheduleId);
            response.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            response.setMsg(ReturnCode.ACTIVE_SUCCESS.msg());
            return response;
        } catch (IllegalArgumentException e) {
            LOGGER.error("create task error,type:{},payload:{}", type, payload, e);
            response.setReturnCode(ReturnCode.ERROR_PARAMS);
            response.setMsg(e.getMessage());
            return response;
        } catch (Exception e) {
            LOGGER.error("create task error,type:{},payload:{}", type, payload, e);
            response.setCode(ReturnCode.ERROR_SERVER.code());
            response.setMsg(ReturnCode.ERROR_SERVER.msg());
            response.setMsg(e.getMessage());
        }

        return response;
    }

    @GetMapping("/task/result/{scheduleId}")
    @ResponseBody
    public TaskResponse<TaskResult> get(@PathVariable Long scheduleId) {
        LOGGER.info("call /task/get , scheduleId={}", scheduleId);

        TaskResponse<TaskResult> response = new TaskResponse<>(ReturnCode.ACTIVE_FAILURE);

        try {
            //   校验参数
            Args.notNull(scheduleId, "scheduleId");

            TaskResult taskResult = taskCommonService.getResult(scheduleId);
            response.setAttach(taskResult);
            response.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            response.setMsg(ReturnCode.ACTIVE_SUCCESS.msg());
            return response;
        } catch (IllegalArgumentException e) {
            LOGGER.error("get task error,scheduleId:{}", scheduleId, e);
            response.setReturnCode(ReturnCode.ERROR_PARAMS);
            response.setMsg(e.getMessage());
            return response;
        } catch (Exception e) {
            LOGGER.error("get task error,scheduleId:{}", scheduleId, e);
            response.setCode(ReturnCode.ERROR_SERVER.code());
            response.setMsg(e.getMessage());
        }
        return response;
    }

    @GetMapping("/task/list")
    @ResponseBody
    public TaskResponse<Page<OpbotSchedule>> getList(@RequestBody OpbotSchedule schedule) {
        LOGGER.info("call /task/list , applyType={},status={},businessId={},shardId={},applyId={},parent={}",
                schedule.getApplyType(),schedule.getStatus(),schedule.getBusinessId(),schedule.getShardId(),schedule.getApplyId(),schedule.isParent());

        TaskResponse<Page<OpbotSchedule>> response = new TaskResponse<>(ReturnCode.ACTIVE_FAILURE);

        Page<OpbotSchedule> page = new Page<OpbotSchedule>(schedule.getPageIndex());
        if (schedule.getPageIndex() <= 0) {
            schedule.setPageSize(page.getPageSize());
        } else {
            page.setPageSize(schedule.getPageSize());
        }

        schedule.setStartIndex(page.getStartIndex());

        List<OpbotSchedule> schedules = jScheduleService.selectSchedule(schedule);
        Integer totalCount = jScheduleService.totalCount(schedule);

        page.setList(schedules);
        page.setTotalCount(totalCount);

        if(schedules != null&&schedules.size()!=0){
            for(int i=0; i<schedules.size(); i++){
                OpbotSchedule inst = schedules.get(i);
                Boolean checkSwitch = jScheduleService.getCheckTopoSwitch(inst.getBusinessId());
                schedules.get(i).setCheckTopoSwitch(checkSwitch);
            }

            response.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            response.setMsg(ReturnCode.ACTIVE_SUCCESS.msg());
            response.setAttach(page);
        }

        return response;

    }

}
