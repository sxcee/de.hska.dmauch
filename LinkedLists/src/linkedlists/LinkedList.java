/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;

/**
 *
 * @author mada1024
 */
public class LinkedList {
    private ListElement firstElement;
    private ListElement lastElement;
    private int size;
    
    public ListElement getFirstElement(){
        return firstElement;
    }
    
    public void setFirstElement(ListElement newElement){
        firstElement = newElement;
    }
    
    public ListElement getLastElement(){
        return lastElement;
    }
    
    public void setLastElement(ListElement newElement){
        lastElement = newElement;
    }
    
    public void addFirst(String value){
        if(size++ == 0){
            ListElement newElement = new ListElement();
            newElement.setValue(value);
            
            setFirstElement(newElement);
            setLastElement(newElement);
        } else {
            ListElement newElement = new ListElement();
            newElement.setValue(value);
            
            newElement.setNextElement(getFirstElement());
            setFirstElement(newElement);
        }
    }
    
    public void addLast(String value){
        if(size++ == 0){
            ListElement newElement = new ListElement();
            newElement.setValue(value);
            
            setFirstElement(newElement);
            setLastElement(newElement);
        } else {
            ListElement newElement = new ListElement();
            newElement.setValue(value);
            
            getLastElement().setNextElement(newElement);
        }
    }
    /*
    noch nicht fertig \|/
    */
    public void add(int index, String value){
        if(size++ >= index){
            ListElement newElement = new ListElement();
            ListElement ptrElement = new ListElement();
            ptrElement = getFirstElement();
            newElement.setValue(value);
            
            while(index-- > 0){
                ptrElement = ptrElement.getNextElement();
            }
            
            newElement = ptrElement.getNextElement();
            ptrElement.setNextElement(newElement);
            newElement.setNextElement(ptrElement.getNextElement());
        } else {
            
        }
    }
    
    public void removeFirstElement(){
        
    }
    
    public void removeLastElement(){
        
    }
    
    public void remove(int index){
        
    }
    
    public int getSize(){
        return size;
    }
    
    
}
