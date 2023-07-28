impl Solution {
    pub fn wonderful_substrings(word: String) -> i64 {
        
        let mut dp = vec![0; 1024];
        let mut mask = 0;
        dp[0] = 1;
        let mut res = 0;
        for ch in word.chars() {
            mask ^= 1 << (ch as u8 - b'a');
            res += dp[mask];
            for i in 0..10 {
                res += dp[mask ^ (1 << i)];
            }
            dp[mask] += 1;
        }
        res
    }
}