package btree;

/**
 * @author kamaj  / jessevaa
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right) {
        root = new Node(rootValue, left, right);
    }

    public void insert(String aData) {
        if (root == null) {
            root = new Node(aData, new BinaryTree(), new BinaryTree());
        } else if (aData.compareTo(root.getData()) < 0) {
            if (root.left() != null) {
                root.left().insert(aData);
            } else {
                this.setLeft(new BinaryTree(aData));
            }
        } else {
            if (root.right() != null) {
                root.right().insert(aData);
            } else {
                this.setRight(new BinaryTree(aData));
            }
        }
    }

    public BinaryTree getSmallest(BinaryTree bt) {
        if (bt.root.left().root == null) {
            return bt;
        } else return getSmallest(bt.root.left());
    }

    BinaryTree deleteNode(BinaryTree tree, String data) {
        BinaryTree treeToDelete = tree.find(data);
        if (treeToDelete == null) {
            return null;
        } else if (treeToDelete.root.left().root == null && treeToDelete.root.right().root == null) {
            treeToDelete.root = null;
        } else if (treeToDelete.root.left().root != null && treeToDelete.root.right().root != null) {
            BinaryTree treeTemp = treeToDelete;
            BinaryTree smallestAtRight = getSmallest(treeToDelete.root.right());
            treeToDelete.root.setData(smallestAtRight.root.getData());
            deleteNode(treeTemp.root.right(), smallestAtRight.root.getData());
        } else if (treeToDelete.root.left().root != null) {
            treeToDelete.root = treeToDelete.root.left().root;
        } else if (treeToDelete.root.right().root != null) {
            treeToDelete.root = treeToDelete.root.right().root;
        }
        return treeToDelete;
    }

    public BinaryTree find(String aData) {
        if (root.getData().contentEquals(aData)) {
            return this;
        }
        if (aData.compareTo(root.getData()) < 0) {
            System.out.print(" < ");
            return root.left().root == null ? null : root.left().find(aData);
        } else {
            System.out.print(" > ");
            return root.right().root == null ? null : root.right().find(aData);
        }
    }

    public void preOrder() {
        if (root != null) {
            System.out.print(root.getData() + ',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
