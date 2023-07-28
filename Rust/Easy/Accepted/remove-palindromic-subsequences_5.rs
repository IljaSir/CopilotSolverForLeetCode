impl Solution {
    pub fn remove_palindrome_sub(s: String) -> i32 {
        
        if s.len() == 0 {
            return 0;
        }
        if s.len() == 1 {
            return 1;
        }
        let mut left = 0;
        let mut right = s.len() - 1;
        while left < right {
            if s.as_bytes()[left] != s.as_bytes()[right] {
                return 2;
            }
            left += 1;
            right -= 1;
        }
        1
    }
}