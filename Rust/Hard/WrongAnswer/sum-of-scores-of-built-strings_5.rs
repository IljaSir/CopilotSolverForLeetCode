impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut i = 0;
        let mut j = s.len() - 1;
        let s = s.as_bytes();
        while i < j {
            if s[i] == s[j] {
                count += 1;
            } else {
                count = 0;
            }
            i += 1;
            j -= 1;
            sum += count as i64;
        }
        sum
    }
}