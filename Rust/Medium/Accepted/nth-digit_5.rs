impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as i64;
        let mut i = 1;
        let mut k = 9;
        while n > i * k {
            n -= i * k;
            i += 1;
            k *= 10;
        }
        let mut num = 1;
        for _ in 0..i - 1 {
            num *= 10;
        }
        num += (n - 1) / i;
        let mut rem = (n - 1) % i;
        while rem < i - 1 {
            num /= 10;
            rem += 1;
        }
        (num % 10) as i32
    }
}