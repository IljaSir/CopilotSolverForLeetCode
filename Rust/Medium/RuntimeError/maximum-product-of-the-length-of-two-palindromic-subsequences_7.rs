impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let n = s.len();
        let mut dp = vec![0; 1 << n];
        let mut res = 0;
        for i in 0..1 << n {
            let mut s = String::new();
            for j in 0..n {
                if (i >> j) & 1 == 1 {
                    s.push(s.chars().nth(j).unwrap());
                }
            }
            let s = s;
            if s == s.chars().rev().collect::<String>() {
                dp[i] = s.len();
            }
            for j in 0..i {
                res = res.max(dp[j] * dp[i ^ j]);
            }
        }
        res as i32
    }
}