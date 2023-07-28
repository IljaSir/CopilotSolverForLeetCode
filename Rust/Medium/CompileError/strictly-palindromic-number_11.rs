impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        le  mut n = n;
        let mut palindromic = t   ;while m > 0 {
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
                        s.push(std::char::from_digit((m % i) as u32, i).unwrap());
         
        palindromic               m /= i;
            }
            if s != s.chars().rev().collect::<String>() {
                return false;
            }
        }
        true
    }
}