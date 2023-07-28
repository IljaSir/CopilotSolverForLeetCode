impl Solution {
    pub fn alternate_digit_sum(n: i32) -> i32 {
        
        let mut n = n;
        let mut sum = 0;
        let mut sign = 1;
        while n > 0 {
            sum += sign * (n % 10);
            sign *= -1;
            n /= 10;
        }
        sum
    }
}