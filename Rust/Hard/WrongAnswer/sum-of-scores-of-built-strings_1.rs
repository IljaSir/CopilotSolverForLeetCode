impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let s = s.as_bytes();
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut res = 0;
        while i < j {
            if s[i] == s[j] {
                res += 2;
                i += 1;
                j -= 1;
            } else {
                i = 0;
                j -= 1;
            }
        }
        res as i64
    }
}