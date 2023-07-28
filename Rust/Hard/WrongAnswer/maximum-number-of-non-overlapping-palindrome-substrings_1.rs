impl Solution {
    pub fn max_palindromes(s: String, k: i32) -> i32 {
        
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
            if i + 1 < n && s[i] == s[i+1] {
                dp[i][i+1] = 2;
            }
        }
        for len in 3..=n {
            for i in 0..n-len+1 {
                let j = i + len - 1;
                if s[i] == s[j] {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = std::cmp::max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        let mut ans = 0;
        let mut cnt = vec![0; 26];
        let mut left = 0;
        for right in 0..n {
            cnt[(s[right] - b'a') as usize] += 1;
            while left < right && cnt[(s[right] - b'a') as usize] > 1 {
                cnt[(s[left] - b'a') as usize] -= 1;
                left += 1;
            }
            if right - left + 1 >= k as usize && dp[left][right] >= k as usize {
                ans += 1;
                left = right + 1;
            }
        }
        ans
    }
}