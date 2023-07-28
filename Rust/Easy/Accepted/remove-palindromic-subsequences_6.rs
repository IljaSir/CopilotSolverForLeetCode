impl Solution {
    pub fn remove_palindrome_sub(s: String) -> i32 {
        
        if s.len() == 0 {
            return 0
        }
        if s.chars().zip(s.chars().rev()).all(|(a, b)| a == b) {
            return 1
        }
        2
    }
}