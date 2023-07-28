impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for word in words {
            if Solution::is_stretchy(&s, &word) {
                res += 1;
            }
        }
        res
    }
    fn is_stretchy(s: &str, word: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < word.len() {
            if s[i..i+1] != word[j..j+1] {
                return false;
            }
            let mut i_len = 1;
            while i + i_len < s.len() && s[i] == s[i + i_len] {
                i_len += 1;
            }
            let mut j_len = 1;
            while j + j_len < word.len() && word[j] == word[j + j_len] {
                j_len += 1;
            }
            if i_len < j_len || (i_len < 3 && i_len != j_len) {
                return false;
            }
            i += i_len;
            j += j_len;
        }
        i == s.len() && j == word.len()
    }
}