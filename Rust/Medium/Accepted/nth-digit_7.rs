impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        

        let mut n = n as u64;
        let mut i = 1;
        let mut base = 1;
        while n > 9 * base * i {
            n -= 9 * base * i;
            base *= 10;
            i += 1;
        }
        let num = base + (n - 1) / i;
        let mut s = num.to_string();
        let i = (n - 1) % i;
        s.chars().nth(i as usize).unwrap().to_digit(10).unwrap() as i32
    }
}