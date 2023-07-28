impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        let mut n = n;
        let mut palindromic = true;
        for base in 2..n {
            let mut base = base;
            let mut x = n;
            let mut y = 0;
            while x > 0 {
                y = y * base + x % base;
                x /= base;
            }
            if y != n {
                palindromic = false;
                break;
            }
        }
        palindromic
    }
}