package com.nts.program.codingchallenge.recursion;


import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Node<T extends Comparable<T>> {

     T  value;
     Node<T> left;
     Node<T> right;
     Node<T> parent;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

}


public class Heap<T extends Comparable<T>> {

    public Node<T> parentNode;
    public Node<T> lastNode;

    public void addNodes(List<T> nodes) {

        nodes.stream().forEach(x->{
            addNode(x);
        });
    }

    public void addNode(T val) {

        if(parentNode == null) {
            parentNode = new Node();
            parentNode.setValue(val);
            parentNode.setParent(null);
        }
        else {

            Node valNode = new Node<T>();
            valNode.setValue(val);
            LinkedList<Node<T>> nodes = Lists.newLinkedList();
            nodes.add(parentNode);
            for(int i=0;i<nodes.size();i++) {

                Node n = nodes.get(i);
                if(n.getLeft()== null) {
                    valNode.setParent(n);
                    n.setLeft(valNode);
                    break;
                }else if(n.getRight()== null) {
                    valNode.setParent(n);
                    n.setRight(valNode);
                    break;
                } else {
                    nodes.add(n.getLeft());
                    nodes.add(n.getRight());
                }
            }
            heapify(valNode);
        }
    }

    public void heapify(Node<T> n){

        Node<T> parent = n.getParent();
        if(parent !=null && n.getValue().compareTo(parent.getValue())> 0) {
            T value = parent.getValue();
            parent.setValue(n.getValue());
            n.setValue(value);
            heapify(parent);
        }
    }

    public void printNodes() {

        recursivePrintNode(parentNode);
    }

    private void recursivePrintNode(Node<T> n) {

        T value = n.getValue();

        System.out.println("level " +value + "----"+ (n.getLeft()!=null?n.getLeft().getValue():" ")+"---"
                + (n.getRight()!=null?n.getRight().getValue():" "));

        if(n.getLeft()!=null)
           recursivePrintNode(n.getLeft());

        if(n.getRight()!=null)
            recursivePrintNode(n.getRight());

    }

    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<Integer>();
        List<Integer> list = Lists.newArrayList(10,50,30,100,1,150,7);
        for(int i=10;i<10000;i++) {

            double d = Math.random();
            int val = (int)(d*10000);
            System.out.println(val +"----------" +d);
            list.add(val);
        }
        Stopwatch stp = Stopwatch.createStarted();
        heap.addNodes(list);

        heap.printNodes();
        System.out.println("time execution "+ stp.stop());
    }
}
