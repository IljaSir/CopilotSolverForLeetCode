impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        

        if dividend == 0 { return 0; }
        if dividend == i32::MIN && divisor == -1 { return i32::MAX; }
        let mut res = 0;
        let mut a = dividend.abs() as i64;
        let b = divisor.abs() as i64;
        let mut c = b;
        let mut i = 1;
        while a >= b {
            while a >= c {
                a -= c;
                res += i;
                i <<= 1;
                c <<= 1;
            }
            i = 1;
            c = b;
        }
        if (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) {
            -res
        } else {
            res
        }
    }
}