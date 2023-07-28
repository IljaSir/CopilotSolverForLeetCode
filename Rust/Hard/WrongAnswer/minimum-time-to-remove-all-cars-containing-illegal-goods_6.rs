impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut ans = 0;
        let mut left = 0;
        let mut right = s.len() - 1;
        let s = s.as_bytes();
        while left < right {
            if s[left] == b'1' && s[right] == b'1' {
                ans += 2;
                left += 1;
                right -= 1;
            } else if s[left] == b'0' {
                left += 1;
            } else if s[right] == b'0' {
                right -= 1;
            }
        }
        if left == right && s[left] == b'1' {
            ans += 1;
        }
        ans
    }
}