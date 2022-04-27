package firstPackage;

@FunctionalInterface
interface MyTreeInterface{
    public void printNode(Node node);
}

class TreeStruct {
    public static void main(String[] args) {
        Node<Integer, String> rootNode = new Node<>(Integer.valueOf(16), "Thats it!");
        int[] arr = RandomArray.getIntRandomArray(20, 15);
        for (int i = 0; i<arr.length; i++){
            Node<Integer, String> newNode = new Node<>(Integer.valueOf(arr[i]), "Whatsùp, doc?");
            rootNode.addNode(newNode);
        }

        Node<Integer, String> nodeTwo = new Node<>(Integer.valueOf(3), "three");
        nodeTwo.addNode(new Node<>(Integer.valueOf(0), "Zero"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(5), "Five"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(10), "Ten"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(7), "Seven"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(6), "Six"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(2), "Two"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(9), "Nine"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(11), "Eleven"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(17), "Seventeen"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(1), "One"));
        nodeTwo.addNode(new Node<>(Integer.valueOf(-1), "-One"));

        nodeTwo.removeKey(Integer.valueOf(3), null);
        nodeTwo.removeKey(Integer.valueOf(-1), null);
        nodeTwo.removeKey(Integer.valueOf(17), null);
        nodeTwo.removeKey(Integer.valueOf(9), null);




        MyTreeInterface face = (Node node) -> {
            System.out.println("Key is : " + node.key + "  For value : " + node.value);
        };

        goThrough(nodeTwo, face);


    }

    public static void goThrough(Node node, MyTreeInterface face){
        if (node.left != null) goThrough(node.left, face);
        face.printNode(node);
        if (node.right != null) goThrough(node.right, face);
    }
}

class Node<K extends Comparable<K>, V> {
    Node<K, V> left, right;
    K key;
    V value;


    public Node(K k, V v){
        this.key = k;
        this.value = v;
        left = null;
        right = null;
    }

    public Node<K, V> removeKey(K k, Node<K, V> rootNode){
        if (key.compareTo(k) == 0){
            if(left == null && right != null){
                key = right.key;
                value = right.value;
                left = right.left;
                right = right.right;
                return new Node<>(key, value);
            }
            if(left != null && right == null){
                key = left.key;
                value = left.value;
                right = right.right;
                left = left.left;
                return new Node<>(key, value);
            }
            if (left != null && right != null){
                Node<K, V> nodeToReplace = findAndRemoveLeftNode(right);
                this.key = nodeToReplace.key;
                this.value = nodeToReplace.value;
                return new Node<>(key, value);
            }
        }
        if (key.compareTo(k) > 0){
            if(left.left == null && left.left == null){
                Node<K, V> toReturn = new Node<>(left.key, left.value);
                this.left = null;
                return toReturn;
            }
            return left.removeKey(k, this);
        }
        if (key.compareTo(k) < 0){
            if(right.left == null && right.right == null){
                Node<K, V> toReturn = new Node<>(right.key, right.value);
                this.right = null;
                return toReturn;
            }
            return right.removeKey(k, this);
        }
        return null;
    }

    public Node<K, V>  findAndRemoveLeftNode(Node<K, V> node){
        Node<K, V> throughNode = node;
        while (throughNode.left != null){
            throughNode = throughNode.left;
        }
        Node<K, V> nodeToReturn = new Node<>(throughNode.key, throughNode.value);
        throughNode.removeKey(throughNode.key, null);
        return nodeToReturn;
    }

    public V findNode(K k) {
        if (k.compareTo(key) == 0) return value;
            if (k.compareTo(key) < 0) {
                if (left != null) return left.findNode(k);
                else return null;
            } else {
                if (right != null) return right.findNode(k);
                else return null;
            }
    }


    public void addNode(Node<K, V> node){
        if(key.compareTo(node.key) == 0) value = node.value;
        if(node.key.compareTo(key) < 0){
            if(left == null) left = node;
            else left.addNode(node);
        }else{
            if(right == null) right = node;
            else right.addNode(node);
        }
    }


}

