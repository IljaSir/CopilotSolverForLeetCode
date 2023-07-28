impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut n = n;
        let mut base = 1;
        let mut last = 9;
        let mut res = 0;
        while n > 0 {
            let digit = n % 10;
            n /= 10;
            if digit > last {
                res = (digit - 1) * base + 10_i32.pow(base.to_string().len() as u32) - 1;
                base *= 10;
                last = digit - 1;
            } else {
                res = digit * base + res;
                base *= 10;
                last = digit;
            }
        }
        res
    }
}