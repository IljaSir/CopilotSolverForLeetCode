impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words = words;
        words.sort();
        let mut set = std::collections::HashSet::new();
        let mut res = String::new();
        for word in words {
            if word.len() == 1 || set.contains(&(word.len() - 1, &word[..word.len() - 1])) {
                if word.len() > res.len() {
                    res = word;
                }
                set.insert((word.len(), &word));
            }
        }
        res
    }
}