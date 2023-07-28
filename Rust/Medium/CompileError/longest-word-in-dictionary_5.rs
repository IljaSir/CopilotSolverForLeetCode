impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        

        let mut ans = String::new();
        let mut words = words;
        words.sort();
        let mut set = std::collections::HashSet::new();
        for word in words {
            if word.len() == 1 || set.contains(&word[0..word.len()-1]) {
                if word.len() > ans.len() {
                    ans = word;
                }
                set.insert(word);
            }
        }
        ans
    }
}