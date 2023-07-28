impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        for target in &target_words {
            let mut ok = false;
            for start in &start_words {
                if Self::is_subsequence(start, target) {
                    ok = true;
                    break;
                }
            }
            if ok {
                ans += 1;
            }
        }
        ans
    }
    fn is_subsequence(s: &str, t: &str) -> bool {
        let mut i = 0;
        for j in 0..t.len() {
            if i < s.len() && s.chars().nth(i).unwrap() == t.chars().nth(j).unwrap() {
                i += 1;
            }
        }
        i == s.len()
    }
}