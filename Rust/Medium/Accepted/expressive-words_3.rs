impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for w in words {
            if Self::is_stretchy(&s, &w) {
                res += 1;
            }
        }
        res
    }
    fn is_stretchy(s: &String, w: &String) -> bool {
        if s.len() < w.len() {
            return false;
        }
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < w.len() {
            if s.chars().nth(i).unwrap() != w.chars().nth(j).unwrap() {
                return false;
            }
            let mut i_count = 1;
            let mut j_count = 1;
            while i + 1 < s.len() && s.chars().nth(i).unwrap() == s.chars().nth(i + 1).unwrap() {
                i_count += 1;
                i += 1;
            }
            while j + 1 < w.len() && w.chars().nth(j).unwrap() == w.chars().nth(j + 1).unwrap() {
                j_count += 1;
                j += 1;
            }
            if j_count > i_count || (i_count < 3 && j_count != i_count) {
                return false;
            }
            i += 1;
            j += 1;
        }
        i == s.len() && j == w.len()
    }
}