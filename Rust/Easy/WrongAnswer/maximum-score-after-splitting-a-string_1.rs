impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut ones = 0;
        let mut zeros = 0;
        let mut ans = 0;
        for c in s.chars() {
            if c == '1' {
                ones += 1;
            }
        }
        for c in s.chars() {
            if c == '0' {
                zeros += 1;
            } else {
                ones -= 1;
            }
            ans = ans.max(zeros + ones);
        }
        ans
    }
}