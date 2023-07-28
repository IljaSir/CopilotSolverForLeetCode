impl Solution {
    pub fn maximum_detonation(bombs: Vec<Vec<i32>>) -> i32 {
        
        let mut bombs = bombs;
        bombs.sort_by(|a, b| (a[2]-b[2]).cmp(&0));
        let mut dp = vec![1; bombs.len()];
        let mut res = 0;
        for i in 0..bombs.len() {
            for j in 0..i {
                if bombs[i][0]-bombs[j][0] > bombs[j][2] {continue;}
                if bombs[i][1]-bombs[j][1] > bombs[j][2] {continue;}
                if (bombs[i][0]-bombs[j][0]).pow(2) + (bombs[i][1]-bombs[j][1]).pow(2) > bombs[j][2].pow(2) {continue;}
                dp[i] = dp[i].max(dp[j]+1);
            }
            res = res.max(dp[i]);
        }
        res
    }
}