impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as i64;
        let mut base = 9;
        let mut digits = 1;
        while n > base * digits as i64 {
            n -= base * digits as i64;
            base *= 10;
            digits += 1;
        }
        let num = 10_i64.pow(digits as u32 - 1) + (n - 1) / digits as i64;
        let i = (n - 1) % digits as i64;
        (num / 10_i64.pow(i as u32) % 10) as i32
    }
}