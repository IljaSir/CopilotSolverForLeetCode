impl Solution {
    pub fn longest_subsequence(s: String, k: i32) -> i32 {
        
        let mut dp = vec![vec![0; s.len()]; 2];
        let mut ans = 0;
        for i in 0..s.len() {
            let mut cur = 0;
            for j in i..s.len() {
                cur = cur * 2 + (s.as_bytes()[j] - b'0');
                if cur > k {
                    break;
                }
                dp[i % 2][j] = cur;
                ans = ans.max(j - i + 1);
            }
        }
        ans as i32
    }
}