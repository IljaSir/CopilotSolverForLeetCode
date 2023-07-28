impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        let mut dividend = dividend as i64;
        let mut divisor = divisor as i64;
        let mut sign = 1;
        if dividend < 0 {
            dividend = 0 - dividend;
            sign = 0 - sign;
        }
        if divisor < 0 {
            divisor = 0 - divisor;
            sign = 0 - sign;
        }
        let mut quotient = 0;
        for i in (0..32).rev() {
            if dividend >= divisor << i {
                dividend -= divisor << i;
                quotient += 1 << i;
            }
        }
        if sign < 0 {
            quotient = 0 - quotient;
        }
        if quotient > i32::max_value() as i64 {
            return i32::max_value();
        }
        if quotient < i32::min_value() as i64 {
            return i32::min_value();
        }
        quotient as i32
    }
}