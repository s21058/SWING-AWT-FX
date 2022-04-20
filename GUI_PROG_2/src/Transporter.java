import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Transporter extends Thread {

    private boolean is_Parking_busy = false;
    private boolean is_wait = true;
    private volatile boolean is_Going = true;
    static int all;
    int id = 0;
    static int count_of_Transport = 0;
    status_of_transporter status;

    enum status_of_transporter {
        Coming, Uploading, Going, Waiting, Delivered, Transporter_Resume;
    }

    public Transporter() {
        id = all++;
        status = status_of_transporter.Waiting;
    }
    // ArrayList<Balloon>balloonArrayList= new ArrayList<>();

    @Override
    public synchronized void run() {
        while (is_Going) {
            while (Storage.getBalloon_TreeMap().size() <= 99) {
                if (!is_Parking_busy) {
                    synchronized (Thread.currentThread().getClass()) {
                        is_Parking_busy = true;
                        try {

                            status = status_of_transporter.Coming;
                            check();
                            if (is_Going) {
                                Thread.sleep(10000);
                                for (int i = 0; i <= 10; i++) {
                                    Storage.remove();
                                }
                                status = status_of_transporter.Going;
                            }
                            // System.out.println("TRACK GONE");

                            is_Parking_busy = false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    status = status_of_transporter.Delivered;
                }
            }
        }
    }

    public void stops() {
        Thread.currentThread().interrupt();
        is_Going = false;
    }

    public void stop_bal() {
        is_Going = false;
    }


    public void run_balloon(){
    is_Going =true;
    }

    public  void check() {
        is_wait = true;
            while (is_wait) {
                System.out.print("");
                status = status_of_transporter.Waiting;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Storage.getBalloon_TreeMap().size() > 10&&is_Going) {
                    is_wait = false;
                    // System.out.println("UPLOAD");
                    status = status_of_transporter.Uploading;
                }
            }
        }

    public status_of_transporter getStatus() {
        return status;
    }

    public int getIds() {
        return id;
    }

    public static void increase_Count_of_Trans(){
    count_of_Transport++;
    }
    public static void reduce_Count_of_Trans(){
    count_of_Transport--;
    }
    static int get_count_of_Trans(){
    return  count_of_Transport;
    }
    public static void show() {
        Set<Map.Entry<Long, Balloon>> entries = Storage.getBalloon_TreeMap().entrySet();
        for (Map.Entry<Long, Balloon> entry : entries) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
//  public void id(){
//        System.out.println("TRUCK ID: "+id);
//    }