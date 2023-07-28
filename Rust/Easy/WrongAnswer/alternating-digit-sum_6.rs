impl Solution {
    pub fn alternate_digit_sum(n: i32) -> i32 {
        
        let mut result = 0;
        let mut n = n;
        let mut sign = 1;
        while n > 0 {
            let digit = n % 10;
            result += sign * digit;
            sign *= -1;
            n /= 10;
        }
        result
    }
}