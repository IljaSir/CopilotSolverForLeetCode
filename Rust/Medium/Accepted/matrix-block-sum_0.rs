impl Solution {
    pub fn matrix_block_sum(mat: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut ans = mat.clone();
        let m = mat.len();
        let n = mat[0].len();
        let mut sum = vec![vec![0; n + 1]; m + 1];
        for i in 1..=m {
            for j in 1..=n {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        for i in 1..=m {
            for j in 1..=n {
                let x1 = (i as i32 - k - 1).max(0) as usize + 1;
                let y1 = (j as i32 - k - 1).max(0) as usize + 1;
                let x2 = (i as i32 + k).min(m as i32) as usize;
                let y2 = (j as i32 + k).min(n as i32) as usize;
                ans[i - 1][j - 1] = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            }
        }
        ans
    }
}