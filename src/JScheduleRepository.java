import com.jd.jimdb.scheduler.data.model.Schedule;
import com.jd.middleware.model.annotation.Repository;

import java.util.List;

@Repository
public interface JScheduleRepository {

    /**
     * 查询正在执行的任务
     *
     * @param applyId
     * @return
     */
    List<Schedule> findRunningSchedulesByApplyId(long applyId);

    List<OpbotSchedule> selectSchedule(OpbotSchedule schedule);
    Integer totalCount(OpbotSchedule schedule);
}
