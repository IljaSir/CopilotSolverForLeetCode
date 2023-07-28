impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let n = s.len();
        if n == 0 {
            return 0;
        }
        let mut dp = vec![0; n];
        let s = s.as_bytes();
        for i in 1..n {
            if Solution::is_palindrome(&s[0..=i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i-1] + 1;
                for j in 1..i {
                    if Solution::is_palindrome(&s[j..=i]) {
                        dp[i] = dp[i].min(dp[j-1] + 1);
                    }
                }
            }
        }
        dp[n-1] as i32
    }
    fn is_palindrome(s: &[u8]) -> bool {
        let n = s.len();
        for i in 0..(n/2) {
            if s[i] != s[n-i-1] {
                return false;
            }
        }
        true
    }
}