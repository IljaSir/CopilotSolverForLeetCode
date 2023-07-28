impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        
        if x < 0 {
            return false;
        }
        let mut x = x;
        let mut rev = 0;
        while x > 0 {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        x == rev
    }
}