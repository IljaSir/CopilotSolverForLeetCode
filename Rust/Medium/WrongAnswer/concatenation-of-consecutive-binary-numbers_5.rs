impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut ans = 0;
        let m = 1_000_000_007;
        for i in 1..=n {
            let mut t = i;
            let mut bits = 0;
            while t > 0 {
                t >>= 1;
                bits += 1;
            }
            ans = ((ans << bits) % m + i) % m;
        }
        ans
    }
}