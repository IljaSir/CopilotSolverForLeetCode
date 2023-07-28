impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut dp = vec![0; s.len()];
        dp[0] = s.as_bytes()[0] as i32 - 48;
        for i in 1..s.len() {
            dp[i] = dp[i - 1] ^ (s.as_bytes()[i] as i32 - 48);
        }
        for q in queries {
            if q[0] == 0 {
                res.push(vec![0, dp.iter().position(|&x| x == q[1]).unwrap() as i32]);
            } else {
                let x = dp[q[0] as usize - 1];
                res.push(vec![q[0], dp.iter().position(|&y| y == q[1] ^ x).unwrap() as i32]);
            }
        }
        return res;
    }
}