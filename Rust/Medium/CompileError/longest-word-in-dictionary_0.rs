impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words = words;
        words.sort_unstable_by(|a, b| {
            if a.len() == b.len() {
                a.cmp(b)
            } else {
                b.len().cmp(&a.len())
            }
        });
        let mut res = String::new();
        let mut set = std::collections::HashSet::new();
        for word in words {
            if word.len() == 1 || set.contains(&word[..word.len() - 1]) {
                if res.len() < word.len() {
                    res = word;
                }
                set.insert(word);
            }
        }
        res
    }
}