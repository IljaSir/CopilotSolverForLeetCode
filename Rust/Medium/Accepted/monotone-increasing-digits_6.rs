impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut n = n;
        let mut digits = vec![];
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        let mut i = 1;
        while i < digits.len() && digits[i - 1] <= digits[i] {
            i += 1;
        }
        if i < digits.len() {
            while i > 0 && digits[i - 1] > digits[i] {
                digits[i - 1] -= 1;
                i -= 1;
            }
            for j in i + 1..digits.len() {
                digits[j] = 9;
            }
        }
        let mut res: i32 = 0;
        for d in digits {
            res = res * 10 + d as i32;
        }
        res
    }
}