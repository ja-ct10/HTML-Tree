package htmltree;
import java.util.Collections;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

public class HtmlTree extends JFrame {
    
    JTree tree;
    
    public HtmlTree() {
        
        DefaultMutableTreeNode html = new DefaultMutableTreeNode("html");
        DefaultMutableTreeNode head = new DefaultMutableTreeNode("head");
        DefaultMutableTreeNode body = new DefaultMutableTreeNode("body");
        
        html.add(head);
        html.add(body);
        
        DefaultMutableTreeNode meta = new DefaultMutableTreeNode("meta");
        DefaultMutableTreeNode title = new DefaultMutableTreeNode("title");
        
        head.add(meta);
        head.add(title);
        
        DefaultMutableTreeNode ul = new DefaultMutableTreeNode("ul");
        DefaultMutableTreeNode h1 = new DefaultMutableTreeNode("h1");
        DefaultMutableTreeNode h2 = new DefaultMutableTreeNode("h2");
        
        body.add(ul);
        body.add(h1);
        body.add(h2);
        
        DefaultMutableTreeNode li = new DefaultMutableTreeNode("li");
        DefaultMutableTreeNode li2 = new DefaultMutableTreeNode("li");
        
        ul.add(li);
        ul.add(li2);
        
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("a");
        
        h2.add(a);
   
        System.out.println("Root Node: " + head.getRoot());
        System.out.println("Parent Nodes: " + head.getParent() + ", " + meta.getParent() + ", " + h1.getParent() + ", " + li.getParent() + ", " + a.getParent());
        System.out.println("Siblings: " + Collections.list(html.children()) + ", " + Collections.list(head.children()) + ", " + Collections.list(body.children()) + ", " + Collections.list(ul.children()) + ", ");
        System.out.println("One-level Subtrees: \n" + html + " - " + Collections.list(html.children()) + ", \n" + head + " - " + Collections.list(head.children()) + ", \n" + body + " - " + Collections.list(body.children()) + ", \n" + ul + " - " + Collections.list(ul.children()) + ", \n" + h2 + " - " + Collections.list(h2.children()));
        System.out.println("Nodes per level: " + "\nLevel " + html.getLevel() + " - " + html.getRoot() + "\nLevel " + head.getLevel() + " - " + Collections.list(html.children()) + "\nLevel " + meta.getLevel() + " - " + Collections.list(head.children()) + ", " + Collections.list(body.children()) + "\nLevel " + li.getLevel() + " - " + Collections.list(ul.children()) + ", " + Collections.list(h2.children()));
        System.out.println("Depth: " + html.getDepth());
        System.out.println("Degree for each one-level subtree: " + "\nSubtree " + html + " - " + html.getChildCount() + "\nSubtree " + head + " - " + head.getChildCount() + "\nSubtree " + body + " - " + body.getChildCount() + "\nSubtree " + ul + " - " + ul.getChildCount() + "\nSubtree " + h2 + " - " + h2.getChildCount());
        
        List breadth = Collections.list(html.breadthFirstEnumeration());
        System.out.println("Breadth-first: " + breadth);
        
        List pre = Collections.list(html.preorderEnumeration());
        System.out.println("Preorder: " + pre);
        
        List post = Collections.list(html.postorderEnumeration());
        System.out.println("Postorder: " + post);
        
        tree = new JTree(html);
        add(tree);
        this.add(tree);
        this.setTitle("JTree Example");
        this.setSize(300, 300);
        this.setVisible(true);
        
    }
   
    public static void main(String[] args) {
        new HtmlTree();
    }
}