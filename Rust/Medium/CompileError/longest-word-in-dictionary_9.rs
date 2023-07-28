impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words = words;
        words.sort();
        let mut trie = Trie::new();
        for word in words.iter() {
            trie.insert(word);
        }
        trie.longest_word()
    }
}