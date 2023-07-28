impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        for c in s.chars() {
            if c == '1' {
                left += 1;
            }
        }
        let mut ans = left;
        for c in s.chars() {
            if c == '1' {
                left -= 1;
            } else {
                right += 1;
            }
            ans = ans.min(left + right);
        }
        ans
    }
}