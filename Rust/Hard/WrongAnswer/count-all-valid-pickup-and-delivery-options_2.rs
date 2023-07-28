impl Solution {
    pub fn count_orders(n: i32) -> i32 {
        
        let mut res = 1;
        let mut modu = 1_000_000_007;
        for i in 1..=n {
            res = (res * (i * 2 - 1) * (i * 2)) % modu;
        }
        res
    }
}