package com.swust.test;

/*
* 自己写一个测试用例
* */
/**
 * @author WENHAO
 * @date 2020/4/28-14:19
 */
public class AddTwoNumber {

    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            return null;
        }
        int carry = 0; //进位
        ListNode pre=new ListNode(0); //疏忽点1：又忘记实例化对象
        ListNode cur = pre;
        while(l1!=null||l2!=null||carry!=0){
            int s1 = l1 == null? 0: l1.val;
            int s2 = l2 == null? 0: l2.val;
            int sum = s1+s2+carry;
            carry = sum/10;

            /*
             * 思考的点，在于如何使数据随着链表往下存放
             * 如何让链表链接起来
             * */
            /*
            * 解析，创建的头节点pre相当于一个坐标，cur最开始是指向坐标的，当有数据来了之后，通过移动cur来
            * 把数据放到链表中。
            *
            * 每一个listnode，负责存一个数据，同时指向下一个listnode
            * */
            cur.next = new ListNode(sum%10);
            cur = cur.next;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return pre.next;
    }


    /*
    * 链表节点的模板
    * */
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
