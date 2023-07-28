impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as i64;
        let mut base = 1;
        let mut digit = 1;
        while n - (9 * base * digit) > 0 {
            n -= 9 * base * digit;
            base *= 10;
            digit += 1;
        }
        let num = base + (n - 1) / digit;
        let mut res = (num / base.pow((n - 1) % digit) % 10) as i32;
        res
    }
}