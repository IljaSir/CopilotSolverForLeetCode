impl Solution {
    pub fn max_side_length(mat: Vec<Vec<i32>>, threshold: i32) -> i32 {
        
        let m = mat.len();
        let n = mat[0].len();
        let mut dp = vec![vec![0; n + 1]; m + 1];
        for i in 1..=m {
            for j in 1..=n {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        let mut ans = 0;
        for i in 1..=m {
            for j in 1..=n {
                let mut l = ans + 1;
                let mut r = std::cmp::min(m - i + 1, n - j + 1);
                while l <= r {
                    let mid = (l + r) / 2;
                    let s = dp[i + mid - 1][j + mid - 1] - dp[i - 1][j + mid - 1] - dp[i + mid - 1][j - 1] + dp[i - 1][j - 1];
                    if s <= threshold {
                        ans = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        ans as i32
    }
}