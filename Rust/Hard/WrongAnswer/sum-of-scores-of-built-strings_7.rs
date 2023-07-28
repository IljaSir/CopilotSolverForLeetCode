impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut sum = 0;
        let mut common = 0;
        let mut s = s.as_bytes();
        let n = s.len();
        let mut i = n - 1;
        while i > 0 {
            if s[i] == s[i-1] {
                common += 1;
            } else {
                common = 0;
            }
            sum += common as i64;
            i -= 1;
        }
        sum
    }
}