package exercise_24_8;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_24_8 extends Application {
    
    public class MyArrayList<E> extends MyAbstractList<E> {
        public static final int INITIAL_CAPACITY = 4;
        private E[] data = (E[])new Object[INITIAL_CAPACITY];
        
        public int getCapacity() {
            return data.length;
        }
        
        private void ensureCapacity() {
            if (size >= data.length) {
                E[] newData = (E[])new Object[size * 2 + 1];
                System.arraycopy(data, 0, newData, 0, size);
                data = newData;
            }
        }
        
        public MyArrayList() { }
        
        public MyArrayList(E[] objects) {
            super(objects);
        }

        @Override
        public void add(int index, E e) {
            ensureCapacity();
            
            // Move elements right
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            
            //insert new element
            data[index] = e;
            
            size++;
        }

        @Override
        public void clear() {
            data = (E[])new Object[INITIAL_CAPACITY];
        }

        @Override
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return true;
                }
            }
            
            return false;
        }

        @Override
        public E get(int index) {
            return data[index];
        }

        @Override
        public int indexOf(E e) {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return i;
                }
            }
            
            return -1;
        }

        @Override
        public int lastIndexOf(E e) {
            for (int i = size - 1; i >= 0; i--) {
                if (e.equals(data[i])) {
                    return i;
                }
            }
            
            return -1;
        }

        @Override
        public boolean remove(E e) {
            if (indexOf(e) >= 0) {
                remove(indexOf(e));
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E remove(int index) {
            E e = data[index];
            
            //shift data left
            for (int i = index; i < size; i++) {
                data[i] = data[i + 1];
            }
            
            data[size-1] = null;
            
            size --;
            
            return e;
        }

        @Override
        public Object set(int index, E e) {
            // TODO: Do This
            return null;
        }
    }
    
    public abstract class MyAbstractList<E> implements MyList<E> {
        protected int size = 0;
        
        /**
         * Default Constructor
         */
        protected MyAbstractList() { }
        
        /**
         * Constructor that accepts an array of item
         * @param objects 
         */
        protected MyAbstractList(E[] objects) {
            for (int i = 0; i < objects.length; i++) {
                add(objects[i]);
            }
        } 

        /**
         * Adds element to end of the list.
         * @param e 
         */
        @Override
        public void add(E e) {
            add(size, e);
        }

        /**
         * Checks if array is empty.
         * @return 
         */
        @Override
        public boolean isEmpty() {
            return size == 0;
        }
        
        /**
         * Gets size
         */
        @Override
        public int size() {
           return size; 
        }
        
    }

    

}
