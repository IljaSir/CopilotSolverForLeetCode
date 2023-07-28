impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
        let mut res = Vec::new();
        for q in queries {
            if q >= 10i32.pow((int_length - 1) as u32) {
                res.push(-1);
            } else {
                let mut num = q;
                let mut rev = q;
                let mut base = 10;
                for _ in 1..(int_length as i32 / 2) {
                    num = num * base + q;
                    rev = rev + q * base;
                    base *= 10;
                }
                if int_length % 2 == 1 {
                    num = num * base + q;
                }
                res.push(num as i64 * base + rev as i64);
            }
        }
        res
    }
}