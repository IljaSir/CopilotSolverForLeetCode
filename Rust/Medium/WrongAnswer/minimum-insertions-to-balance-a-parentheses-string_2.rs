impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut ans = 0;
        let mut left = 0;
        let mut right = 0;
        for c in s.chars() {
            if c == '(' {
                left += 1;
            } else {
                right += 1;
            }
            if left == right {
                left = 0;
                right = 0;
            } else if right > left {
                ans += 1;
                right -= 1;
                left = 0;
            }
        }
        ans += left * 2;
        ans
    }
}