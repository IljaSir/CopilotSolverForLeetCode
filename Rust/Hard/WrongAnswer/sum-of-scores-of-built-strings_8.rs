impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut res = 0;
        let mut prev = 0;
        let mut n = s.len();
        let mut s = s.into_bytes();
        for i in (0..n).rev() {
            if s[i] == s[n-1] {
                prev += 1;
            } else {
                prev = 0;
            }
            res += prev as i64;
        }
        res
    }
}