impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words = words;
        words.sort();
        let mut max = String::from("");
        let mut set = std::collections::HashSet::new();
        for word in words {
            if word.len() == 1 || set.contains(&word[..word.len()-1]) {
                if word.len() > max.len() {
                    max = word.clone();
                }
                set.insert(word);
            }
        }
        max
    }
}