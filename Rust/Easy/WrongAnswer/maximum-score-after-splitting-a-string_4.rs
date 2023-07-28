impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        for c in s.chars() {
            if c == '1' {
                right += 1;
            }
        }
        for c in s.chars() {
            if c == '1' {
                right -= 1;
            } else {
                left += 1;
            }
            count = left + right;
            if count > max {
                max = count;
            }
        }
        max
    }
}