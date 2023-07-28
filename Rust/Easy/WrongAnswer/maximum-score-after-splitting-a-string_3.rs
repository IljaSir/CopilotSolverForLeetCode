impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut result = 0;
        let mut ones = 0;
        let mut zeros = 0;
        for ch in s.chars() {
            if ch == '1' {
                ones += 1;
            }
        }
        for ch in s.chars() {
            if ch == '0' {
                zeros += 1;
            } else {
                ones -= 1;
            }
            result = result.max(zeros + ones);
        }
        result
    }
}