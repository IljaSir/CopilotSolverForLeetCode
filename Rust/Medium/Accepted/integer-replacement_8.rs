impl Solution {
    pub fn integer_replacement(n: i32) -> i32 {
        

        let mut n = n as u64;
        let mut ret = 0;
        while n != 1 {
            if n % 2 == 0 {
                n /= 2;
            } else if n == 3 || (n >> 1) % 2 == 0 {
                n -= 1;
            } else {
                n += 1;
            }
            ret += 1;
        }
        ret
    }
}