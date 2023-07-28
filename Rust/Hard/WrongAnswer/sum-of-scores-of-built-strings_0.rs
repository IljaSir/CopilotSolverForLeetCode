impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let s = s.as_bytes();
        let mut res = 0;
        for i in 0..s.len() {
            if s[i] == s[s.len() - 1] {
                res += s.len() - i;
            }
        }
        res as i64
    }
}