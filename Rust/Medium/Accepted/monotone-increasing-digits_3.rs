impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut n = n;
        let mut digits: Vec<i32> = vec![];
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
            for i in (i + 1)..digits.len() {
                digits[i] = 9;
            }
        }
        digits.iter().fold(0, |acc, x| acc * 10 + x)
    }
}