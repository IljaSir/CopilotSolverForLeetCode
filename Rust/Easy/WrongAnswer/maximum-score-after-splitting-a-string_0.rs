impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut zeros = 0;
        let mut ones = 0;
        let mut max_score = 0;
        for c in s.chars() {
            if c == '0' {
                zeros += 1;
            } else {
                ones += 1;
            }
        }
        let mut left_zeros = 0;
        let mut right_ones = ones;
        for c in s.chars() {
            if c == '0' {
                left_zeros += 1;
            } else {
                right_ones -= 1;
            }
            max_score = max_score.max(left_zeros + right_ones);
        }
        max_score
    }
}