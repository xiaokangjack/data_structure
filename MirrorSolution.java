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