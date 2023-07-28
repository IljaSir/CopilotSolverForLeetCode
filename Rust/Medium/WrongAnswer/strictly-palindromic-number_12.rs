impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        let mut n = n;
        while n > 0 {
            if n % 10 != 1 && n % 10 != 0 {
                return false;
            }
            n /= 10;
        }
        true
    }
}