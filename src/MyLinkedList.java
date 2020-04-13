import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MyLinkedList<T> implements ILinkedList<T>{
    private Node<T> last;
    private Node<T> first;
    private int size=0;

    private static class Node<T>{

        T item;
        MyLinkedList.Node<T> next;
        MyLinkedList.Node<T> prev;

        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next){
            this.item=element;
            this.next=next;
            this.prev=prev;
        }
    }

    class MyIterator implements Iterator<T>{
        private MyLinkedList.Node<T> node=first;

        @Override
        public boolean hasNext(){
            return nonNull(node);
        }

        @Override
        public T next(){
            MyLinkedList.Node<T> temp=node;
            if(nonNull(node)){
                node=node.next;
            }
            return temp.item;
        }
    }

    MyLinkedList.Node<T> node(int index){

        if(index<(size >> 1)){
            MyLinkedList.Node<T> x=first;
            for (int i=0; i<index; i++)
                x=x.next;
            return x;
        } else {
            MyLinkedList.Node<T> x=last;
            for (int i=size-1; i>index; i--)
                x=x.prev;
            return x;
        }
    }

    void linkLast(T element){
        final MyLinkedList.Node<T> l=last;
        final MyLinkedList.Node<T> newNode=new MyLinkedList.Node<>(l, element, null);
        last=newNode;
        if(l == null)
            first=newNode;
        else
            l.next=newNode;
        size++;
    }

    void linkBefore(T e, MyLinkedList.Node<T> succ){
        // assert succ != null;
        final MyLinkedList.Node<T> pred=succ.prev;
        final MyLinkedList.Node<T> newNode=new MyLinkedList.Node<>(pred, e, succ);
        succ.prev=newNode;
        if(pred == null)
            first=newNode;
        else
            pred.next=newNode;
        size++;
    }

    private boolean isElementIndex(int index){
        return index >= 0 && index<size;
    }

    private String outOfBoundsMsg(int index){
        return "Index: "+index+", Size: "+size;
    }

    private void checkElementIndex(int index){
        if(!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    T unlink(MyLinkedList.Node<T> x){
        final T element=x.item;
        final MyLinkedList.Node<T> next=x.next;
        final MyLinkedList.Node<T> prev=x.prev;

        if(prev == null){
            first=next;
        } else {
            prev.next=next;
            x.prev=null;
        }

        if(next == null){
            last=prev;
        } else {
            next.prev=prev;
            x.next=null;
        }

        x.item=null;
        size--;
        return element;
    }

    @Override
    public void add(T element){
        final MyLinkedList.Node<T> l=last;
        final MyLinkedList.Node<T> newNode=new MyLinkedList.Node<>(l, element, null);
        last=newNode;
        if(l == null)
            first=newNode;
        else
            l.next=newNode;
        size++;

    }

    @Override
    public void add(int index, T element){
        if(index == size){
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override
    public void clear(){
        for (MyLinkedList.Node<T> x=first; x != null; ){
            MyLinkedList.Node<T> next=x.next;
            x.item=null;
            x.next=null;
            x.prev=null;
            x=next;
        }
        first=last=null;
        size=0;
    }

    @Override
    public T get(int index){
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public int indexOf(T element){
        int index=0;
        if(element == null){
            for (MyLinkedList.Node<T> x=first; x != null; x=x.next){
                if(x.item == null)
                    return index;
                index++;
            }
        } else {
            for (MyLinkedList.Node<T> x=first; x != null; x=x.next){
                if(element.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }


    @Override
    public T remove(int index){
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public T set(int index, T element){
        checkElementIndex(index);
        MyLinkedList.Node<T> x=node(index);
        T oldVal=x.item;
        x.item=element;
        return oldVal;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public T[] toArray(){
        Object[] result=new Object[size];
        int i=0;
        for (MyLinkedList.Node<T> x=first; x != null; x=x.next)
            result[i++]=x.item;
        return (T[]) result;
    }

    @Override
    public Iterator<T> iterator(){
        return new MyIterator();
    }

    @Override
    public String toString(){
        if(isNull(first)){
            return "[]";
        }
        String s="[";
        MyLinkedList.Node<T> myNode=first;
        while(nonNull(myNode)) {
            s=s.concat(Objects.toString(myNode.item)).concat(", ");
            myNode=myNode.next;
        }
        return s.substring(0, s.length()-2).concat("]");
    }
}
