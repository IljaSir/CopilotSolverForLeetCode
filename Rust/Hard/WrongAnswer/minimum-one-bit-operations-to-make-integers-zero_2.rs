impl Solution {
    pub fn minimum_one_bit_operations(n: i32) -> i32 {
        
        let mut n = n;
        let mut ans = 0;
        let mut k = 30;
        while k >= 0 {
            if n & (1 << k) != 0 {
                ans += (1 << (k + 1)) - 1;
                n ^= (1 << (k + 1)) - 1;
            }
            k -= 1;
        }
        ans
    }
}