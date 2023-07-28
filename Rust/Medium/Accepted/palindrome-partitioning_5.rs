impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        let bytes = s.as_bytes();
        let n = bytes.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            for j in (0..=i).rev() {
                if bytes[i] == bytes[j] && (i - j <= 2 || dp[j + 1][i - 1]) {
                    dp[j][i] = true;
                }
            }
        }
        Self::dfs(0, &bytes, &mut res, &mut path, &dp);
        res
    }
    fn dfs(
        idx: usize,
        bytes: &[u8],
        res: &mut Vec<Vec<String>>,
        path: &mut Vec<String>,
        dp: &Vec<Vec<bool>>,
    ) {
        let n = bytes.len();
        if idx == n {
            res.push(path.clone());
            return;
        }
        for i in idx..n {
            if dp[idx][i] {
                path.push(String::from_utf8_lossy(&bytes[idx..i + 1]).to_string());
                Self::dfs(i + 1, bytes, res, path, dp);
                path.pop();
            }
        }
    }
}