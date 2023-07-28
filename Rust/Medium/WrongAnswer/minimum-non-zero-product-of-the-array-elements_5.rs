impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let modu = 1_000_000_007;
        let p = p as u64;
        let mut ans = 1;
        for i in 0..(p - 1) {
            ans = ans * (1 << p - 1 - i) % modu;
        }
        ans = ans * (ans - 1) % modu;
        ans as i32
    }
}