impl Solution {
    pub fn distinct_averages(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = nums[i];
        }
        for i in 0..n {
            for j in i+1..n {
                dp[i][j] = dp[i][j-1] + nums[j];
            }
        }
        let mut ans = 0;
        let mut visited = vec![false; n];
        for i in 0..n {
            for j in i+1..n {
                let mut k = i;
                let mut l = j;
                while k < l {
                    let m = (k + l) / 2;
                    let a = dp[i][m] - dp[i][i-1];
                    let b = dp[m+1][j] - dp[m+1][j-1];
                    if a == b {
                        if !visited[m] {
                            visited[m] = true;
                            ans += 1;
                        }
                        k = m + 1;
                        l = m;
                    } else if a > b {
                        l = m;
                    } else {
                        k = m + 1;
                    }
                }
            }
        }
        ans as i32
    }
}