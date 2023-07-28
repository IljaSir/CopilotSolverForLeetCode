impl Solution {
    pub fn count_good_numbers(n: i64) -> i32 {
        
        let mut ans = 1;
        let mut n = n;
        let mut modu = 1_000_000_007;
        while n > 0 {
            if n & 1 == 1 {
                ans = ans * 5 % modu;
            }
            n >>= 1;
            ans = ans * ans % modu;
        }
        ans as i32
    }
}