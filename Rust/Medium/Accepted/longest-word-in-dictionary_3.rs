impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words = words;
        words.sort();
        let mut res = String::new();
        let mut set = std::collections::HashSet::new();
        for word in words {
            if word.len() == 1 || set.contains(&(word[..word.len()-1].to_string())) {
                if word.len() > res.len() {
                    res = word.clone();
                }
                set.insert(word);
            }
        }
        res
    }
}