impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for word in words {
            if Solution::is_expressive(&s, &word) {
                res += 1;
            }
        }
        res
    }
    
    fn is_expressive(s: &str, word: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < word.len() {
            if s.chars().nth(i) != word.chars().nth(j) {
                return false;
            }
            let mut i_end = i;
            while i_end < s.len() && s.chars().nth(i_end) == s.chars().nth(i) {
                i_end += 1;
            }
            let mut j_end = j;
            while j_end < word.len() && word.chars().nth(j_end) == word.chars().nth(j) {
                j_end += 1;
            }
            if i_end - i < j_end - j {
                return false;
            }
            if i_end - i < 3 && i_end - i != j_end - j {
                return false;
            }
            i = i_end;
            j = j_end;
        }
        i == s.len() && j == word.len()
    }
}