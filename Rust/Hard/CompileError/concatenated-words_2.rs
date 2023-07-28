impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut words: Vec<String> = words.into_iter().filter(|s| s.len() > 0).collect();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut ans = vec![];
        let mut set = HashSet::new();
        for i in 0..words.len() {
            if Self::is_concat(&words[i], &set) {
                ans.push(words[i].clone());
            }
            set.insert(words[i].clone());
        }
        ans
    }
    fn is_concat(s: &String, set: &HashSet<String>) -> bool {
        if set.contains(s) {
            return true;
        }
        for i in 1..s.len() {
            if set.contains(&s[..i]) && Self::is_concat(&s[i..].to_string(), set) {
                return true;
            }
        }
        false
    }
}