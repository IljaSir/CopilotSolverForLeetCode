impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words = words;
        words.sort();
        let mut longest = "".to_string();
        let mut set = std::collections::HashSet::new();
        for word in words {
            if word.len() == 1 || set.contains(&word[..word.len()-1]) {
                if word.len() > longest.len() {
                    longest = word.clone();
                }
                set.insert(word);
            }
        }
        longest
    }
}