impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut cnt = vec![0; 1001];
        for &x in &nums {
            cnt[x as usize] += 1;
        }
        let mut sub = vec![];
        for i in 0..=1000 {
            if cnt[i] > 1 {
                sub.push(cnt[i]);
            }
        }
        let n = sub.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = sub[i];
        }
        for l in 2..=n {
            for i in 0..n-l+1 {
                let j = i + l - 1;
                dp[i][j] = dp[i][j-1] + sub[j];
            }
        }
        let mut sum = vec![0; n];
        sum[0] = sub[0];
        for i in 1..n {
            sum[i] = sum[i-1] + sub[i];
        }
        let mut f = vec![vec![0; n]; k as usize];
        for i in 0..n {
            f[0][i] = sum[i];
        }
        for i in 1..k as usize {
            for j in 0..n {
                f[i][j] = f[i-1][j];
                for k in 0..j {
                    f[i][j] = f[i][j].min(f[i-1][k] + dp[k+1][j]);
                }
            }
        }
        f[k as usize - 1][n-1] as i32
    }
}