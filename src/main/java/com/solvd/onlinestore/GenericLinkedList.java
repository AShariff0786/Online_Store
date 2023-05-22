package com.solvd.onlinestore;

import com.solvd.onlinestore.exceptions.ItemNotFoundException;

import java.util.stream.IntStream;

public class GenericLinkedList<T> {
    private Node<T> head;
    private int size;

    //default constructor
    public GenericLinkedList() {
        this.head = null;
    }

    public void add(T t) {
        Node<T> temp = new Node<>(t);
        if (this.head == null) {
            this.head = temp;
        } else {
            //temporary node to get to end of linkedlist
            Node<T> iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(temp);
        }
        size++;
    }

    public void remove(T t) {
        Node<T> prev = new Node<>(null);
        prev.setNext(head);
        Node<T> next = head.getNext();
        Node<T> temp = head;
        boolean containsValue = false;

        //Deletes head node if it contains value
        if (head.getData() == t) {
            head = head.getNext();
            containsValue = true;
        }
        while (temp.getNext() != null) {
            if (temp.getData() == t) {
                prev.setNext(next);
                containsValue = true;
                break;
            }
            prev = temp;
            temp = temp.getNext();
            next = temp.getNext();
        }

        //checks last node
        if (containsValue == false && temp.getData() == t) {
            prev.setNext(null);
            containsValue = true;
        }

        if (containsValue) {
            size--;
        } else {
            throw new ItemNotFoundException("Item was not found");
        }
    }

    public T get(int ind) {
        Node<T> temp = head;
        for (int i = 0; i < ind; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public int size() {
        return size;
    }
}
