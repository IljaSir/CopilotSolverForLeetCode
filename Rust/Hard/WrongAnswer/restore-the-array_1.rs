impl Solution {
    pub fn number_of_arrays(s: String, k: i32) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let k = k as usize;
        let mut dp = vec![0; n + 1];
        dp[n] = 1;
        for i in (0..n).rev() {
            let mut j = i;
            let mut num = 0;
            while j < n && num <= k {
                num = num * 10 + (s[j] - b'0') as usize;
                if num > 0 && num <= k {
                    dp[i] = (dp[i] + dp[j + 1]) % 1000000007;
                }
                j += 1;
            }
        }
        dp[0] as i32
    }
}