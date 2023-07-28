impl Solution {
    pub fn remove_palindrome_sub(s: String) -> i32 {
        
        if s.is_empty() {
            return 0;
        }
        let s1 = s.clone();
        let s2 = s1.chars().rev().collect::<String>();
        if s1 == s2 {
            return 1;
        }
        2
    }
}