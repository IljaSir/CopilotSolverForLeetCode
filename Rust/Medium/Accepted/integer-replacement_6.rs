impl Solution {
    pub fn integer_replacement(n: i32) -> i32 {
        

        let mut n = n as u64;
        let mut ans = 0;
        while n != 1 {
            if n & 1 == 0 {
                n >>= 1;
            } else if n == 3 || (n >> 1) & 1 == 0 {
                n -= 1;
            } else {
                n += 1;
            }
            ans += 1;
        }
        ans as i32
    }
}