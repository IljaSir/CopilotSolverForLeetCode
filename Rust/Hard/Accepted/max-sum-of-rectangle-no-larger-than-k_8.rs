impl Solution {
    pub fn max_sum_submatrix(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let m = matrix.len();
        let n = matrix[0].len();
        let mut sum = vec![vec![0; n + 1]; m + 1];
        let mut res = i32::MIN;
        for i in 1..=m {
            for j in 1..=n {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        for i in 1..=m {
            for j in 1..=n {
                for p in i..=m {
                    for q in j..=n {
                        let cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];
                        if cur <= k {
                            res = res.max(cur);
                        }
                    }
                }
            }
        }
        res
    }
}