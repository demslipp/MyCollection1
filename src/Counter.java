import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Counter{
    Random random=new Random();
    private static long startTime;
    private static long endTime;

    public void insert(List list, String s){
        for (int i=0; i<100000; i++){
            list.add(new Circle(random.nextInt()));
        }
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
        list.clear();
    }

    public void insertAtTheEnd(List list, String s){
        startTime=System.nanoTime();
        for (int i=0; i<100000; i++){
            list.add(new Circle(random.nextInt()));
        }
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
    }

    public int findElement(List list){
        return random.nextInt(list.size());
    }

    public void getElement(List list, String s){
        startTime=System.nanoTime();
        list.get(random.nextInt(list.size()));
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
    }

    public void insertInSet(Set set, String s){
        startTime=System.nanoTime();
        for (int i=0; i<1000; i++){
            set.add(i);
        }
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
        set.clear();
    }

    public void insertAtTheEndInSet(Set set, String s){
        startTime=System.nanoTime();
        for (int i=0; i<1000; i++){
            set.add(i);
        }
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
    }

    public void getSize(Set set, String s){
        startTime=System.nanoTime();
        set.size();
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
    }

    public void calcPut(Map map, String s){
        int size=map.size();
        startTime=System.nanoTime();
        for (int i=size; i<size+1000; i++){
            map.put(i, new Circle(random.nextInt()));
        }
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
    }
    public void getMapSize(Map map, String s){
        startTime=System.nanoTime();
        map.size();
        endTime=System.nanoTime();
        System.out.println(s+(endTime-startTime));
    }

}

