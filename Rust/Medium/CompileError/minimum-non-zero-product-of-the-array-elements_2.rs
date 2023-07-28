impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let p = p as u64;
        let modu = 1_000_000_007;
        let max = (1 << p) - 1;
        let half = 1 << (p - 1);
        let mut res = max;
        res *= max - 1;
        res %= modu;
        res *= half.pow((max - 1) as u32);
        res %= modu;
        res as i32
    }
}