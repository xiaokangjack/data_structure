# README

---

## 树
### 二叉树的镜像

操作给定的二叉树，将其变换为源二叉树的镜像。 
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5

思路：先序遍历树的每个结点，若遍历到的结点有子结点，则交换它的两个子结点。可以使用栈来实现遍历。
```
import java.util.*;
public class MirrorSolution {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();//定义一个栈，后进先出
        stack.push(root);//根节点入栈
        while(!stack.empty()) {//栈非空
            TreeNode node = stack.pop();//栈顶元素出栈， 并获得其值
            if(node.left != null || node.right != null) {//是否有子节点
                TreeNode nodeLeft = node.left;//获取左子结点，可能不存在
                TreeNode nodeRight = node.right;//获取右子节点，可能不存在
                //交换两个节点位置
                node.left = nodeRight;
                node.right = nodeLeft;
            }
            //继续向下遍历，存入栈中
            if(node.left != null) stack.push(node.left);//左子结点入栈
            if(node.right != null) stack.push(node.right);//右子节点入栈
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
 
    }
 
}
```




## 链表

### 删除链表中重复的结点

题目描述：
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。<br>

解题思路：
关键是注意指针的指向，可以定义一个newHead对象（主要用于返回操作后的链表），newHead.next指向head，定义一个pre同样指向newHead（主要用于记录要删除节点的前一个节点），定义一个cur指向head，指向当前节点。<br>
操作流程：
1、先判断当前cur指向，为空则进入6，不为空进入2；<br>
2、循环判断当前节点cur的值与与cur.next的值是否相等，如果相等，进入3，不相等，进入4；<br>
3、cur向后移一位，继续循环2；<br>
4、此时cur指向的是相同节点串中的最后一个节点，而pre则是相同节点串的前一个节点，通过pre.next = cur.next操作可以删除整个节点串；<br>
5、无论3和4哪个执行，cur都后移一位；<br>
6、返回newHead.next；<br>
```
public class DeleteDuplicationSolution {
    public ListNode deleteDuplication(ListNode head) {
        {
            if (head == null)
                return head;
            
            ListNode newHead = new ListNode(0);
            newHead.next = head;//newHead-->head
            ListNode pre = newHead;//用于记录要删除节点的前一个节点
            ListNode cur = head;//当前节点
            while (cur != null) {//结束条件：当前节点为空
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;//退出while循环时，cur指向的是相同节点值串中的最后一个
                }
                if (pre.next == cur) {//pre的下一个节点是cur，即两者相邻。注意是指针，不是节点值
                    pre = pre.next;//后移
                } else {//此时pre和cur不相邻，说明中间有重复节点存在
                    pre.next = cur.next;//删除重复的节点
                }
                cur = cur.next;//后移
            }
            return newHead.next;
        }

    }
}

class ListNode {
    int val;

    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```