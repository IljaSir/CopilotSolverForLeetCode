impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..=n {
            let mut j = i;
            let mut bits = 0;
            while j > 0 {
                j >>= 1;
                bits += 1;
            }
            res = (res * (1 << bits) + i) % (1_000_000_007);
        }
        res as i32
    }
}