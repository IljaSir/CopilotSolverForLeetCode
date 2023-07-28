impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        let mut ans = 0;
        for c in s.chars() {
            if c == '(' {
                if right % 2 == 1 {
                    ans += 1;
                    right -= 1;
                }
                left += 1;
            } else {
                right += 1;
            }
            if right > left {
                ans += right / 2;
                left += right / 2;
                right %= 2;
            }
        }
        if right % 2 == 1 {
            ans += 1;
            right -= 1;
        }
        ans += right / 2;
        ans += left - right;
        ans
    }
}