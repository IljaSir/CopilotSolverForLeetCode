impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        
        if x < 0 {
            return false;
        }
        let mut x = x;
        let mut d = 1;
        while x / d >= 10 {
            d *= 10;
        }
        while x > 0 {
            let q = x / d;
            let r = x % 10;
            if q != r {
                return false;
            }
            x = (x % d) / 10;
            d /= 100;
        }
        true
    }
}