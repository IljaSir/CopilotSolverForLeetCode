impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        
        if x < 0 {
            return false;
        }
        let mut str = x.to_string();
        let mut rev_str = str.chars().rev().collect::<String>();
        if rev_str == str {
            return true;
        }
        return false;
    }
}