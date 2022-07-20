package algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//
// Note: This is code for a future episode. Stay tuned!
//

public class TrieTest {

    private Trie trie;

    @Before
    public void SetUp() {
        trie = new Trie();
    }

    @Test
    public void StartsWith() {
        trie.insert("Apple");
        Assert.assertTrue(trie.startsWith("A"));
        Assert.assertTrue(trie.startsWith("Ap"));
        Assert.assertTrue(trie.startsWith("App"));
        Assert.assertTrue(trie.startsWith("Appl"));
        Assert.assertTrue(trie.startsWith("Apple"));
    }

    @Test
    public void ContainsWord() {
        trie.insert("pot");
        trie.insert("past");
        trie.insert("pass");
        trie.insert("part");

        Assert.assertTrue(trie.containsWord("pot"));
        Assert.assertTrue(trie.containsWord("past"));
        Assert.assertTrue(trie.containsWord("pass"));
        Assert.assertTrue(trie.containsWord("part"));
        Assert.assertFalse(trie.containsWord("ps"));
    }
}
