impl Solution {
    pub fn wonderful_substrings(word: String) -> i64 {
        
        let mut dp = vec![1; 1024];
        let mut mask = 0;
        let mut ans = 0;
        for c in word.chars() {
            mask ^= 1 << (c as u8 - b'a');
            ans += dp[mask];
            for i in 0..10 {
                ans += dp[mask ^ (1 << i)];
            }
            dp[mask] += 1;
        }
        ans
    }
}