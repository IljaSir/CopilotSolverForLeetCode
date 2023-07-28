impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        for base in 2..=n-2 {
            let mut num = n;
            let mut s = String::new();
            while num > 0 {
                let d = num % base;
                num /= base;
                s.push((d as u8 + b'0') as char);
            }
            if s != s.chars().rev().collect::<String>() {
                return false;
            }
        }
        true
    }
}