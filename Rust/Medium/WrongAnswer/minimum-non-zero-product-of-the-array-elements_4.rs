impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let m = 1_000_000_007;
        let n = 1 << p;
        let n = n as i64;
        let n = n - 1;
        let n = n as i32;
        let mut res = 1;
        let mut i = 0;
        while i < p / 2 {
            res = (res * (n - (1 << i))) % m;
            i += 1;
        }
        (res * res) % m
    }
}