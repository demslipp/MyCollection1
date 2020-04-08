public class Main{

    public static void main(String[] args){
        ILinkedList<Integer> myList=new MyLinkedList();
        myList.add(12);
        myList.add(13);
        
        myList.add(1, 33);


        System.out.println(myList);

    }
}
