import com.jd.jim.common.utils.Page;
import com.jd.jimdb.export.domain.TaskResponse;
import com.jd.jimdb.model.model.TaskResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class ScheduleControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleControllerTest.class);

    @Inject
    private ScheduleController scheduleController;
    @Test
    public void testCreate() {
        TaskResponse response=scheduleController.create("split","81001004","split","1");
        LOGGER.info("TaskResponse result,msg:{},attach:{}",response.getMsg(),response.getAttach());
    }

    @Test
    public void testGet() {
        TaskResponse<TaskResult> response=scheduleController.get(4234234L);
        LOGGER.info("TaskResponse result,msg:{},attach:{}",response.getMsg(),response.getAttach());
    }

    @Test
    public void testGetList() {
        OpbotSchedule schedule=new OpbotSchedule();
        schedule.setApplyType("\"split\"");
        schedule.setStatus(1);
        schedule.setBusinessId("\"81001004\"");
        schedule.setShardId(null);
        schedule.setApplyId(967618);
        schedule.setParent(true);
        TaskResponse<Page<OpbotSchedule>> response=scheduleController.getList(schedule);
        LOGGER.info("TaskResponse result,msg:{}",response.getMsg());
    }
}