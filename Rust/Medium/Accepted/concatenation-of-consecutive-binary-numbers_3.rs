impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut res = 0;
        let mut modu = 1_000_000_007;
        for i in 1..=n {
            let mut j = i;
            while j > 0 {
                res = (res << 1) % modu;
                j >>= 1;
            }
            res = (res + i) % modu;
        }
        res
    }
}