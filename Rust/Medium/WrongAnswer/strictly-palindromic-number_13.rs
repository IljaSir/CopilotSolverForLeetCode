impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        if n < 10 {
            return true;
        }
        let mut n = n;
        let mut digits = Vec::new();
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        let mut i = 0;
        let mut j = digits.len() - 1;
        while i < j {
            if digits[i] != digits[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        for b in 2..=n - 2 {
            let mut n = n;
            let mut digits = Vec::new();
            while n > 0 {
                digits.push(n % b);
                n /= b;
            }
            let mut i = 0;
            let mut j = digits.len() - 1;
            while i < j {
                if digits[i] != digits[j] {
                    return false;
                }
                i += 1;
                j -= 1;
            }
        }
        true
    }
}