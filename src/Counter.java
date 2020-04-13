import java.util.List;
import java.util.Random;

public class Counter{
    Random random=new Random();

    public List insert(List list){
        for (int i=0; i<100000; i++){
            list.add(new Circle(random.nextInt()));
        }
        return list;
    }

    public List insertAtTheEnd(List list){
        for (int i=list.size(); i<200000; i++){
            list.add(new Circle(random.nextInt()));
        }
        return list;
    }

    public int findElement(List list){

        return random.nextInt(list.size());
    }

}
