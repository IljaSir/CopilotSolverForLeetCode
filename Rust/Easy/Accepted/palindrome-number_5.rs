impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        
        let mut y = x;
        let mut z = 0;
        while y > 0 {
            z = z * 10 + y % 10;
            y /= 10;
        }
        return x == z;
    }
}