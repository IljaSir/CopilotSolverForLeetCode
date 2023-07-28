impl Solution {
    pub fn can_make_pali_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![0; 26]; n + 1];
        for i in 0..n {
            for j in 0..26 {
                dp[i + 1][j] = dp[i][j];
            }
            dp[i + 1][s[i] as usize - 'a' as usize] += 1;
        }
        let mut res = vec![];
        for query in queries {
            let (l, r, k) = (query[0] as usize, query[1] as usize, query[2] as usize);
            let mut odd = 0;
            for i in 0..26 {
                if (dp[r + 1][i] - dp[l][i]) % 2 == 1 {
                    odd += 1;
                }
            }
            res.push(odd / 2 <= k);
        }
        res
    }
}