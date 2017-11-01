/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterviewjava;

import java.util.Hashtable;
import java.lang.Exception;

/**
 *
 * @author fukuda
 */
class Node {

    Node next_ = null;
    int data_;

    Node(int data, Node next) {
        data_ = data;
        next_ = next;
    }

    Node(int data) {
        data_ = data;
    }

    Node appendToTail(Node add) {
        Node node = this;

        while (node.next_ != null) {
            node = node.next_;
        }

        node.next_ = add;
        return add;
    }

}

public class Chapter2 {

    Node deleteDuplicateNode(Node head) {
        //最初の数を記憶して、頭から走査して同じ数があるかどうかを調べ、あったら削除O(n^2)
        //削除にO(n)なのでO(n^3),重い

        Node node = head;
        Node firstLoopNode = head;
        int num = head.data_;

        while (firstLoopNode != null) {
            num = firstLoopNode.data_;
            node = firstLoopNode.next_;
            while (node != null) {
                if (node.data_ == num) {
                    node = deleteNodeByData(head, num);
                } else {
                    node = node.next_;
                }
            }
            firstLoopNode = firstLoopNode.next_;
        }
        return head;
    }

    Node deleteNodeByData(Node head, int data) {
        Node returnNode = head;

        while (returnNode.data_ == data) {
            returnNode = returnNode.next_;
        }

        Node node = returnNode;
        Node nextNode = node.next_;

        while (nextNode != null) {
            //次にdataが異なるノードを見つけるまで探して繋ぎ直す
            while (nextNode.data_ == data) {
                nextNode = nextNode.next_;
                if (nextNode == null) {
                    break;
                }
            }

            node.next_ = nextNode;
            if (nextNode == null) {
                break;
            }
            node = node.next_;
            nextNode = node.next_;
        }

        return returnNode;
    }

    void deleteDups(Node n) {
        Hashtable table = new Hashtable();
        Node pre = null;

        while (n != null) {
            if (table.containsKey(n.data_)) {
                pre.next_ = n.next_;
            } else {
                pre = n;
                table.put(n.data_, true);
            }
            n = n.next_;
        }
    }

    Node lastK(Node head,int k) {
        //O(n^2)
        
        int count = 1;
        Node n = head;
        while (n.next_ != null) {
            count++;
            n = n.next_;
        }

        n = head;
        count -= k;
        
        if(count < 0) return head;
        
        while(count != 0){
            n = n.next_;
            count --;
        }
        return n;
    }
    
    Node lastKAns(Node head,int k){
        if(k < 0) return head;
        
        Node n = head;
        Node nk = head;
        int count = 1;
        while(count != k){
            nk = nk.next_;
            count++;
            if(nk == null) return head;
        }
        
        while(nk.next_ != null){
            n = n.next_;
            nk = nk.next_;
        }
        
        return n;
    }

    boolean deleteNode(Node n){
        if(n == null || n.next_ == null) return false;
        
        Node next = n.next_;
        
        n.data_ = next.data_;
        n.next_ = next.next_;
        return true;
    }
    
    Node separateByX(Node head,int x){
        Node underXF = null;
        Node underXL = null;
        Node overAndEqualXF = null;
        Node overAndEqualXL = null;
        Node n = head;
        
        while(n != null){
            if(n.data_ < x){
                if(underXF == null){
                    underXF = n;
                    underXL = n;
                }else{
                    underXL.next_ = n;
                    underXL = n;
                }
            }else{
                if(overAndEqualXF == null){
                    overAndEqualXF = n;
                    overAndEqualXL = n;
                }
                else{
                    overAndEqualXL.next_ = n;
                    overAndEqualXL = n;
                }
            }
            n = n.next_;
        }
        
        underXL.next_ = overAndEqualXF;
        overAndEqualXL.next_ = null;
        
        return underXF;
    }
    
    void showList(Node head) {
        Node node = head;
        while (node.next_ != null) {
            System.out.print(node.data_ + " ");
            node = node.next_;
        }
        System.out.print(node.data_ + "\n");
    }

    String list(Node head) {
        Node node = head;
        String returnString = "";

        while (node.next_ != null) {
            returnString += node.data_ + " ";
            node = node.next_;
        }
        return returnString + node.data_;
    }
}