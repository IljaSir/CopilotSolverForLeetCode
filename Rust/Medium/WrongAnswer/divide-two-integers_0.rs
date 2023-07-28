impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        let mut dividend = dividend as i64;
        let mut divisor = divisor as i64;
        let sign = (dividend < 0) ^ (divisor < 0);
        dividend = dividend.abs();
        divisor = divisor.abs();
        let mut result = 0;
        while dividend >= divisor {
            let mut temp = divisor;
            let mut multiple = 1;
            while dividend >= (temp << 1) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividend -= temp;
            result += multiple;
        }
        if sign {
            return -result as i32;
        } else {
            return result as i32;
        }
    }
}