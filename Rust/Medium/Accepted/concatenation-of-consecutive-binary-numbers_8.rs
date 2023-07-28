impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut res: i64 = 0;
        let mut modu: i64 = 1_000_000_007;
        for i in 1..=n {
            let mut j = i;
            while j > 0 {
                res = (res << 1) % modu;
                j >>= 1;
            }
            res = (res + i as i64) % modu;
        }
        res as i32
    }
}