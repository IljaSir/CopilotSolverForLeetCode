impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut longest = "".to_string();
        for word in dictionary {
            if word.len() < longest.len() || (word.len() == longest.len() && word > longest) {
                continue;
            }
            if Self::is_subsequence(&word, &s) {
                longest = word;
            }
        }
        longest
    }
    fn is_subsequence(word: &str, s: &str) -> bool {
        let mut iter = s.chars();
        for c in word.chars() {
            if let Some(next) = iter.find(|&x| x == c) {
                iter = next.into_iter().chain(iter);
            } else {
                return false;
            }
        }
        true
    }
}