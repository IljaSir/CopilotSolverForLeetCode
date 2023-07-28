impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        let mut dividend = dividend;
        let mut divisor = divisor;
        let mut result = 0;
        let mut is_negative = false;
        if dividend < 0 {
            is_negative = !is_negative;
            dividend = -dividend;
        }
        if divisor < 0 {
            is_negative = !is_negative;
            divisor = -divisor;
        }
        while dividend >= divisor {
            let mut temp = divisor;
            let mut count = 1;
            while dividend >= temp {
                dividend -= temp;
                result += count;
                count <<= 1;
                temp <<= 1;
            }
        }
        if is_negative {
            -result
        } else {
            result
        }
    }
}