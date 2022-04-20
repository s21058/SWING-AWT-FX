import static java.lang.Thread.sleep;

public class Factory extends Thread {
    private  boolean is_stop = false;
     int count_of_ballon = 0;
    Storage storage = new Storage();
    static int all=0;
    long time;
    int id=0;
    Factory(){
        id=all++;
        set_time_to_sleep();
    }

    @Override
    public void run() {
        while (!is_stop) {
            if (storage.getMap_size() < 99) {
                synchronized (Factory.class) {
                    Balloon balloon = new Balloon(BallonColor.getRandom_Color());

//                    System.out.println("CREATING BALLOON: "+count_of_ballon++);
                    count_of_ballon++;
                    Storage.add_to_map(balloon.id_balloon, balloon);
                    storage.drop_all();
                }
                try {
                    Thread.sleep(getTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void stops(){
        is_stop =true;
    }
    public long set_time_to_sleep() {
        time = (long) ((Math.random() * 3000 - 100) + 100);
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public int getCount_of_ballon() {
        return count_of_ballon;
    }


    public int getIds() {
        return id;
    }
}
