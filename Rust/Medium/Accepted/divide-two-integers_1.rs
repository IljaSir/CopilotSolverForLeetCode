impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        let mut dividend = dividend as i64;
        let mut divisor = divisor as i64;
        let mut sign = 1;
        if dividend < 0 {
            dividend = -dividend;
            sign = -sign;
        }
        if divisor < 0 {
            divisor = -divisor;
            sign = -sign;
        }
        let mut res = 0;
        while dividend >= divisor {
            let mut tmp = divisor;
            let mut mul = 1;
            while dividend >= tmp {
                dividend -= tmp;
                res += mul;
                tmp <<= 1;
                mul <<= 1;
            }
        }
        if sign == 1 {
            std::cmp::min(res, i32::max_value() as i64) as i32
        } else {
            std::cmp::max(-res, i32::min_value() as i64) as i32
        }
    }
}