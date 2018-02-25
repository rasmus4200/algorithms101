package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode {
        char c;
        boolean isWholeWord;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        // for each letter in the word string...
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);

            // See if there is a node already representing this letter

            // if there is
            // get it
            // else create it with it's own internal HashMap of letters

            TrieNode n;
            if (children.containsKey(c)) {
                n = children.get(c);
            } else {
                n = new TrieNode(c);
                children.put(c, n);
            }

            // this is the magic line here...
            children = n.children;

            // Take this newly created, or found, node
            // And reset the children variable to point to it's children
            //
            // This is how we continuously step further down the try
            // and insert more letters (even repeating letters) deeper in the
            // data structure.
            //
            // Now when we loop again, we will will loop from here
            // And insert the next letters from this starting point in the word


            // Set this flag to represent that this node is also a full word
            if (i == word.length() - 1) {
                n.isWholeWord = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean contains(String word) {
        TrieNode t = containsNode(word);

        if(t != null && t.isWholeWord)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return containsNode(prefix) != null;
    }

    public TrieNode containsNode(String str){

        // This method walks the string one letter at a time
        // continuously returning a found nodes children,
        // so long as there is a match.

        // If there is a match, it returns the final node.
        // Else it returns null - meaning no match.

        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            } else{
                return null;
            }
        }

        return t;
    }
}
