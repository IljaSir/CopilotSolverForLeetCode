impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut digits = Vec::new();
        let mut n = n;
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        let mut res = String::new();
        for i in (0..digits.len()).rev() {
            res.push((digits[i] + '0' as u8) as char);
            if (digits.len() - i) % 3 == 0 && i != 0 {
                res.push('.');
            }
        }
        res
    }
}