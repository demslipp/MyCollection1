import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Main{
    private static long startTime;
    private static long endTime;

    public void forInteger(){

        Counter counter=new Counter();
        Random random=new Random();
        ILinkedList<Integer> myList=new MyLinkedList<>();
        List<Integer> linkedList=new LinkedList<>();
        List<Integer> arrayList=new ArrayList<>();
        System.out.println("1");
        for (int a=0; a<10; a++){
            startTime=System.nanoTime();
            for (int i=0; i<100000; i++){
                myList.add(i);
            }
            endTime=System.nanoTime();
            System.out.println("My list: "+(endTime-startTime));
            counter.insert(arrayList, "Array list: ");
            counter.insert(linkedList, "Linked list: ");
        }
        System.out.println("2");
        for (int a=0; a<10; a++){
            startTime=System.nanoTime();
            for (int i=myList.size(); i<100000; i++){
                myList.add(i);
            }
            endTime=System.nanoTime();
            System.out.println("My list: "+(endTime-startTime));
            startTime=System.nanoTime();
            counter.insertAtTheEnd(arrayList, "My list: ");
            counter.insertAtTheEnd(linkedList, "Linked list: ");
        }
        System.out.println("3");
        for (int a=0; a<10; a++){
            startTime=System.nanoTime();
            myList.get(random.nextInt(myList.size()));
            endTime=System.nanoTime();
            System.out.println("My list: "+(endTime-startTime));
            startTime=System.nanoTime();
            arrayList.get(counter.findElement(arrayList));
            endTime=System.nanoTime();
            System.out.println("Array list: "+(endTime-startTime));
            startTime=System.nanoTime();
            linkedList.get(counter.findElement(linkedList));
            endTime=System.nanoTime();
            System.out.println("Linked list: "+(endTime-startTime));
        }
        System.out.println("4");
        for (int a=0; a<10; a++){
            startTime=System.nanoTime();
            myList.remove(random.nextInt(myList.size()));
            endTime=System.nanoTime();
            System.out.println("My list: "+(endTime-startTime));
            startTime=System.nanoTime();
            arrayList.remove(counter.findElement(arrayList));
            endTime=System.nanoTime();
            System.out.println("Array list: "+(endTime-startTime));
            startTime=System.nanoTime();
            linkedList.remove(counter.findElement(linkedList));
            endTime=System.nanoTime();
            System.out.println("Linked list: "+(endTime-startTime));
        }
        System.out.println("5");
        System.out.println(myList.size());
        System.out.println(arrayList.size());
        System.out.println(linkedList.size());

        System.out.println("6");
        for (int a=0; a<myList.size(); a++){
            myList.remove(a);
        }
        System.out.println(myList.size());

        for (int a=0; a<arrayList.size(); a++){
            arrayList.remove(a);
        }
        System.out.println(arrayList.size());
        for (int a=0; a<linkedList.size(); a++){
            linkedList.remove(a);
        }
        System.out.println(linkedList.size());
    }
}
