impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        let mut l = 0;
        let mut r = chars.len() - 1;
        while l < r {
            if chars[l] != chars[r] {
                return Self::is_palindrome(&chars, l + 1, r) || Self::is_palindrome(&chars, l, r - 1);
            }
            l += 1;
            r -= 1;
        }
        true
    }
    
    fn is_palindrome(chars: &[char], mut l: usize, mut r: usize) -> bool {
        while l < r {
            if chars[l] != chars[r] {
                return false;
            }
            l += 1;
            r -= 1;
        }
        true
    }
}