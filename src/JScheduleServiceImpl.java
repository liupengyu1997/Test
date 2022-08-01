import com.jd.jim.cli.Cluster;
import com.jd.jimdb.model.repository.JScheduleRepository;
import com.jd.jimdb.scheduler.data.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class JScheduleServiceImpl implements JScheduleService {

    @Inject
    private JScheduleRepository jScheduleRepository;

    @Autowired
    private static String CHECK_TOPO_SWITCH_PRIX = "check_topo_switch_spaceId_";

    @Resource(name = "jimClient")
    private Cluster jimClient;

    @Override
    public List<Schedule> findRunningSchedulesByApplyId(long applyId) {
        return jScheduleRepository.findRunningSchedulesByApplyId(applyId);
    }

    @Override
    public List<OpbotSchedule> selectSchedule(OpbotSchedule schedule) {
        return jScheduleRepository.selectSchedule(schedule);
    }

    @Override
    public Integer totalCount(OpbotSchedule schedule) {
        return jScheduleRepository.totalCount(schedule);
    }

    @Override
    public boolean getCheckTopoSwitch(String spaceId) {
        String key = CHECK_TOPO_SWITCH_PRIX + spaceId;
        String checkSwitch = jimClient.get(key);
        if(checkSwitch != null && checkSwitch.equalsIgnoreCase("no")){
            return false;
        }else{
            return true;
        }
    }

}
