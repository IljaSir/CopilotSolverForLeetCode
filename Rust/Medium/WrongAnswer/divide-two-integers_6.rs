impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        let mut res = 0;
        let mut a = dividend.abs() as i64;
        let b = divisor.abs() as i64;
        let mut c = b;
        while a >= b {
            let mut cnt = 1;
            while a >= c {
                a -= c;
                res += cnt;
                cnt <<= 1;
                c <<= 1;
            }
            c = b;
        }
        if (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) {
            res = -res;
        }
        if res > std::i32::MAX as i64 {
            std::i32::MAX
        } else if res < std::i32::MIN as i64 {
            std::i32::MIN
        } else {
            res as i32
        }
    }
}