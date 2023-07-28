impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        let mut i = 1;
        while i < words.len() {
            if words[i-1].chars().collect::<Vec<char>>().sort() == words[i].chars().collect::<Vec<char>>().sort() {
                words.remove(i);
            } else {
                i += 1;
            }
        }
        words
    }
}