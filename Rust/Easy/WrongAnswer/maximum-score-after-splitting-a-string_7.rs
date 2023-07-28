impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut sum: i32 = 0;
        for c in s.chars() {
            if c == '1' { sum += 1; }
        }
        let mut max: i32 = sum;
        let mut left: i32 = 0;
        for c in s.chars() {
            if c == '1' { sum -= 1; } else { left += 1; }
            let tmp = sum + left;
            if tmp > max { max = tmp; }
        }
        max
    }
}