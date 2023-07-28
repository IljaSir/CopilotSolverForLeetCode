impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut result = 0;
        let mut mod_ = 1_000_000_007;
        for i in 1..=n {
            let mut x = i;
            let mut num = 0;
            while x > 0 {
                x >>= 1;
                num += 1;
            }
            result = (result << num) % mod_ + i as i32;
            result %= mod_;
        }
        result
    }
}