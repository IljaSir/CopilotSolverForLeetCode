impl Solution {
    pub fn remove_palindrome_sub(s: String) -> i32 {
        
        if s.is_empty() {
            return 0;
        }
        if s.chars().rev().eq(s.chars()) {
            return 1;
        }
        2
    }
}