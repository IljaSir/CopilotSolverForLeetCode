impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut words: Vec<String> = words;
        words.sort();
        let mut res = String::new();
        let mut set = std::collections::HashSet::new();
        for word in words.iter() {
            if word.len() == 1 || set.contains(&word[0..word.len()-1]) {
                if word.len() > res.len() {
                    res = word.clone();
                }
                set.insert(word);
            }
        }
        res
    }
}