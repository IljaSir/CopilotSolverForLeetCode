impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let modu = 1000000007;
        let mut ans = 1;
        let mut p = p as u64;
        while p > 1 {
            ans = ans * (2u64.pow(p) - 1) % modu;
            ans = ans * 2u64.pow(p - 1) % modu;
            p -= 1;
        }
        ans as i32
    }
}