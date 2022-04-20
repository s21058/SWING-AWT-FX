import java.util.TreeMap;

public class Storage{
    private static  boolean flag=false;
    static private final TreeMap<Long,Balloon> balloon_TreeMap = new TreeMap<>();

    public static void add_to_map(long id_balloon, Balloon balloon) {
        balloon_TreeMap.put(id_balloon, balloon);
        System.out.println(balloon_TreeMap.size()+" "+id_balloon);
    }
    static void remove() {
        balloon_TreeMap.pollFirstEntry();
    }
    public int getMap_size() {
         return balloon_TreeMap.size();
    }
public void drop_all() {
    if (getMap_size() > 89) {
//        flag = true;
        Field.get_anim();
        balloon_TreeMap.clear();
        System.gc();
    }
}

    public static TreeMap<Long, Balloon> getBalloon_TreeMap() {
        return balloon_TreeMap;
    }
}

