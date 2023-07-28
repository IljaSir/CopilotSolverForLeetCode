impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        
        let mut num = x;
        let mut rev = 0;
        if x < 0 {return false;}
        while num > 0 {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev == x;
    }
}