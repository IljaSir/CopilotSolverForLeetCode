impl Solution {
    pub fn best_team_score(scores: Vec<i32>, ages: Vec<i32>) -> i32 {
        
        let mut v = Vec::new();
        for i in 0..scores.len() {
            v.push((scores[i], ages[i]));
        }
        v.sort();
        let mut dp = vec![0; v.len()];
        dp[0] = v[0].0;
        for i in 1..v.len() {
            dp[i] = v[i].0;
            for j in 0..i {
                if v[j].1 <= v[i].1 {
                    dp[i] = dp[i].max(dp[j] + v[i].0);
                }
            }
        }
        *dp.iter().max().unwrap()
    }
}