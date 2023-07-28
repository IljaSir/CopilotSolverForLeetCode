impl Solution {
    pub fn remove_palindrome_sub(s: String) -> i32 {
        
        if s.len() == 0 {
            return 0;
        }
        let mut s = s.chars().collect::<Vec<char>>();
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if s[l] == s[r] {
                l += 1;
                r -= 1;
            } else {
                return 2;
            }
        }
        1
    }
}