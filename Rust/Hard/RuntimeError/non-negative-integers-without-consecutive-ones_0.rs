impl Solution {
    pub fn find_integers(n: i32) -> i32 {
        
        let mut dp = vec![0; 32];
        dp[0] = 1;
        dp[1] = 2;
        for i in 2..32 {
            dp[i] = dp[i-1] + dp[i-2];
        }
        let mut ans = 0;
        let mut k = 30;
        let mut pre_bit = 0;
        while k >= 0 {
            if (n & (1 << k)) != 0 {
                ans += dp[k];
                if pre_bit == 1 {
                    ans -= 1;
                    break;
                }
                pre_bit = 1;
            } else {
                pre_bit = 0;
            }
            if k == 0 {
                ans += 1;
            }
            k -= 1;
        }
        ans
    }
}