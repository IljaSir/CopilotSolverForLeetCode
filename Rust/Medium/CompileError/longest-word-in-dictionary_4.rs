impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words: Vec<_> = words.into_iter().map(|s| s.into_bytes()).collect();
        words.sort_unstable_by(|a, b| {
            if a.len() == b.len() {
                a.cmp(b)
            } else {
                b.len().cmp(&a.len())
            }
        });
        let mut result = Vec::new();
        let mut set = std::collections::HashSet::new();
        for word in words {
            if word.len() == 1 || set.contains(&word[..word.len() - 1]) {
                if word.len() >= result.len() {
                    result = word;
                }
                set.insert(word);
            }
        }
        String::from_utf8(result).unwrap()
    }
}