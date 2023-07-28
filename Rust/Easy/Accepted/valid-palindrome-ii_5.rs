impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let chars = s.chars().collect::<Vec<char>>();
        let mut left = 0;
        let mut right = chars.len() - 1;
        while left < right {
            if chars[left] != chars[right] {
                return Self::valid_palindrome_from(&chars, left + 1, right) ||
                    Self::valid_palindrome_from(&chars, left, right - 1);
            }
            left += 1;
            right -= 1;
        }
        true
    }
    fn valid_palindrome_from(chars: &Vec<char>, left: usize, right: usize) -> bool {
        let mut left = left;
        let mut right = right;
        while left < right {
            if chars[left] != chars[right] {
                return false;
            }
            left += 1;
            right -= 1;
        }
        true
    }
}