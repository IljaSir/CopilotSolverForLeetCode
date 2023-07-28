impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let modu = 1_000_000_007;
        let mut res = 1;
        for i in 0..p {
            res = (res * 2) % modu;
        }
        let mut res = (res - 2) % modu;
        let mut a = 1;
        for i in 0..p-1 {
            a = (a * 2) % modu;
        }
        res = (res * a) % modu;
        res
    }
}