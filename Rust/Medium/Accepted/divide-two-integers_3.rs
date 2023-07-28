impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        let mut dividend = dividend as i64;
        let mut divisor = divisor as i64;
        let mut result = 0;
        let mut sign = 1;
        if dividend < 0 {
            dividend = -dividend;
            sign = -sign;
        }
        if divisor < 0 {
            divisor = -divisor;
            sign = -sign;
        }
        while dividend >= divisor {
            let mut divisor_ = divisor;
            let mut count = 1;
            while dividend >= divisor_ {
                dividend -= divisor_;
                result += count;
                divisor_ = divisor_ << 1;
                count = count << 1;
            }
        }
        if sign == -1 {
            result = -result;
        }
        if result > i32::MAX as i64 {
            i32::MAX
        } else if result < i32::MIN as i64 {
            i32::MIN
        } else {
            result as i32
        }
    }
}