import java.util.*;

public class MainTest{
    private static long startTime;
    private static long endTime;

    public static void main(String[] args){
        Counter counter=new Counter();
        Random random=new Random();
        ILinkedList<Circle> myList=new MyLinkedList();
        List<Circle> linkedList=new LinkedList<>();
        List<Circle> arrayList=new ArrayList<>();

        Main main = new Main();
        System.out.println("Results for Integer");
        main.forInteger();

        System.out.println("Results for others");
        System.out.println("1");
        for (int a=0; a<10; a++){
            startTime=System.nanoTime();
            for (int i=0; i<100000; i++){
                myList.add(new Circle(random.nextInt()));
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
                myList.add(new Circle(random.nextInt()));
            }
            endTime=System.nanoTime();
            System.out.println("My list: "+(endTime-startTime));
            myList.clear();
            counter.insertAtTheEnd(arrayList, "Array list: ");
            counter.insertAtTheEnd(linkedList, "Linked list: ");
        }
        System.out.println("3");
        for (int a=0; a<10; a++){
            for (int i=myList.size(); i<100000; i++){
                myList.add(new Circle(random.nextInt()));
            }
            startTime=System.nanoTime();
            myList.get(random.nextInt(myList.size()));
            endTime=System.nanoTime();
            System.out.println("My list: "+(endTime-startTime));
            counter.getElement(arrayList, "Array list: ");
            counter.getElement(linkedList, "Linked list: ");
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

        Set hashSet=new HashSet();
        Set linkedHashSet=new LinkedHashSet<>();
        Set treeSet=new TreeSet();

        System.out.println("5");
        for (int i=0; i<10; i++){
            counter.insertInSet(hashSet, "hash set: ");
            counter.insertInSet(linkedHashSet, "linked hash set: ");
            counter.insertInSet(treeSet, "tree set: ");
        }
        System.out.println("6");
        for (int a=0; a<10; a++){
            counter.insertAtTheEndInSet(hashSet, "hash set: ");
            counter.insertAtTheEndInSet(linkedHashSet, "linked hash set: ");
            counter.insertAtTheEndInSet(treeSet, "tree set: ");
        }
        System.out.println("7");
        for (int a=0; a<10; a++){
            counter.getSize(hashSet, "hash set: ");
            counter.getSize(linkedHashSet, "linked hash set: ");
            counter.getSize(treeSet, "tree set: ");
        }

        Map hashMap=new HashMap();
        Map linkedHashMap=new LinkedHashMap();
        Map treeMap=new TreeMap();

        System.out.println("8");
        for (int a=0; a<10; a++){
            counter.calcPut(hashMap, "hash map: ");
            counter.calcPut(linkedHashMap, "linked hash map: ");
            counter.calcPut(treeMap, "tree map: ");
        }
        System.out.println("9");
        for (int a=0; a<10; a++){
            counter.getMapSize(hashMap, "hash map: ");
            counter.getMapSize(linkedHashMap, "linked hash map: ");
            counter.getMapSize(treeMap, "tree map: ");
        }
    }
}