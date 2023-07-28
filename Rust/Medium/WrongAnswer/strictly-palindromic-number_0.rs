impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        for b in 6..n - 1 {
            if !Self::is_palindromic(n, b) {
                return false;
            }
        }
        true
    }
    
    fn is_palindromic(n: i32, b: i32) -> bool {
        let mut n = n;
        let mut v = vec![];
        while n > 0 {
            v.push((n % b) as u8);
            n /= b;
        }
        v == v.iter().rev().cloned().collect::<Vec<_>>()
    }
}