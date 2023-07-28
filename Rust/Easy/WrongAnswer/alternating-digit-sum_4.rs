impl Solution {
    pub fn alternate_digit_sum(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut n = n;
        let mut sign = true;
        while n > 0 {
            let digit = n % 10;
            if sign {
                sum += digit;
            } else {
                sum -= digit;
            }
            sign = !sign;
            n /= 10;
        }
        sum
    }
}