impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut dp = vec![0; s.len() + 1];
        for i in 0..s.len() {
            dp[i + 1] = dp[i] ^ (s.as_bytes()[i] - b'0') as i32;
        }
        queries.iter().map(|v| {
            let (first, second) = (v[0], v[1]);
            for i in 0..s.len() {
                if dp[i + 1] ^ first == second {
                    return vec![i as i32, (i + 1) as i32];
                }
            }
            vec![-1, -1]
        }).collect()
    }
}