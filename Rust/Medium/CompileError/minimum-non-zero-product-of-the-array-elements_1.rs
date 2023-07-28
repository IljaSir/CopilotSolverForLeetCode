impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let m = 1_000_000_007;
        let mut ans = 1;
        for i in 0..p {
            ans = ans * 2 % m;
        }
        ans = (ans - 2) % m;
        ans = ans * pow(ans as i64, (1 << p) - 2, m as i64) as i32 % m;
        ans as i32
    }
}