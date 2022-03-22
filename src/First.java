import java.nio.charset.StandardCharsets;
import java.util.*;

public class First {
    public static void main(String[] args) {
//        Set<Integer> set=new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(1);
//        System.out.println(set);
//        System.out.println(1);
//        System.out.println(2);
//        System.out.println(3);

//        boolean parent_id=false;//父任务
//        Long parentId=0L;
//
//        System.out.println();
        List<Long> list=new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(null);
        for(int i=0;i<list.size();i++){
            Long parentId=list.get(i);
            if(list.get(i)==null) continue;
            if(list.get(i)==2){
                list.remove(i);
            }
        }
//        System.out.println(list);
//        Long parentId=23767L;
//        if(null==parentId){
//            System.out.println("父任务");
//        }else {
//            System.out.println("子任务");
//        }
//        if(null!=parentId){
//            System.out.println("子任务");
//        }else {
//            System.out.println("父任务");
//        }
        List<String> platformList = new ArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");

        for(String key:platformList){
            System.out.println(key.getBytes());
        }

//        for (String platform : platformList) {
//            if (platform.equals("博客园")) {
//                platformList.remove(platform);
//            }
//        }

        Iterator<String> iterator = platformList.iterator();
        while (iterator.hasNext()) {
            String platform = iterator.next();
            if (platform.equals("博客园")) {
                iterator.remove();
            }
        }

        System.out.println(platformList);
        System.out.println("新增分支");


    }
}
