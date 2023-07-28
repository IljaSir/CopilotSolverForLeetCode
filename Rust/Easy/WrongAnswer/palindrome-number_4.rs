impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        
        if x < 0 { return false; }
        let mut x = x;
        let mut y = 0;
        while x != 0 {
            y = y * 10 + x % 10;
            x /= 10;
        }
        y == x
    }
}