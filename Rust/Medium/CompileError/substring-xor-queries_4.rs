impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut s = s.as_bytes();
        let mut dp = vec![0; s.len() + 1];
        for i in 0..s.len() {
            dp[i + 1] = dp[i] ^ (s[i] - b'0');
        }
        for q in queries {
            let (l, r) = (q[0] as usize, q[1] as usize);
            res.push(vec![dp[l as usize] ^ dp[r + 1] ^ r as i32, r as i32]);
        }
        res
    }
}