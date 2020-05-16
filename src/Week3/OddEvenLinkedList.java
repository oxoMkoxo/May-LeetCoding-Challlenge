/*
 * 328. Odd Even Linked List
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are 
 * talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * 	Example 1:
 * 		Input: 1->2->3->4->5->NULL
 * 		Output: 1->3->5->2->4->NULL
 * 
 * 	Example 2:
 * 		Input: 2->1->3->5->6->4->7->NULL
 * 		Output: 2->3->6->7->1->5->4->NULL
 * 
 * 	Note:
 * 		The relative order inside both the even and odd groups should remain as it was in the input.
 * 		The first node is considered odd, the second node even and so on ...
 * 
 * 
 * 
 */
package Week3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class OddEvenLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void display(ListNode head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
			if (head != null) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		OddEvenLinkedList obj = new OddEvenLinkedList();
		ListNode head = obj.new ListNode(Integer.parseInt(st.nextElement().toString()));
		ListNode temp = head;
		while (st.hasMoreElements()) {
			temp.next = obj.new ListNode(Integer.parseInt(st.nextElement().toString()));
			temp = temp.next;
		}
//		obj.display(head);
//		System.out.println(maxSubarraySumCircular(A));
		obj.oddEvenList(head);
		obj.display(head);
		scn.close();
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evensHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evensHead;
		return head;
	}

}
