public class DeleteDuplicationSolution {
    public ListNode deleteDuplication(ListNode head) {
        {
            if (head == null)
                return head;

            ListNode newHead = new ListNode(0);
            newHead.next = head;// newHead-->head
            ListNode pre = newHead;// 用于记录要删除节点的前一个节点
            ListNode cur = head;// 当前节点
            while (cur != null) {// 结束条件：当前节点为空
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;// 退出while循环时，cur指向的是相同节点值串中的最后一个
                }
                if (pre.next == cur) {// pre的下一个节点是cur，即两者相邻。注意是指针，不是节点值
                    pre = pre.next;// 后移
                } else {// 此时pre和cur不相邻，说明中间有重复节点存在
                    pre.next = cur.next;// 删除重复的节点
                }
                cur = cur.next;// 后移
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