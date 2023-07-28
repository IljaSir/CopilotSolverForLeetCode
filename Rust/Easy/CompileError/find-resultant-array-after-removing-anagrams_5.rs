impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        let mut i = 0;
        while i < words.len() - 1 {
            if words[i].chars().sorted().eq(words[i + 1].chars().sorted()) {
                words.remove(i + 1);
            } else {
                i += 1;
            }
        }
        words
    }
}