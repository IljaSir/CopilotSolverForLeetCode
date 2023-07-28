impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let (row, col) = (destination[0] as usize, destination[1] as usize);
        let mut dp = vec![vec![0; col + 1]; row + 1];
        dp[row][col] = 1;
        for i in (0..=row).rev() {
            for j in (0..=col).rev() {
                if i == row && j == col {
                    continue;
                }
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        let mut res = String::new();
        let mut (i, j) = (0, 0);
        let mut k = k - 1;
        while i < row || j < col {
            if i == row {
                res.push('H');
                j += 1;
            } else if j == col {
                res.push('V');
                i += 1;
            } else {
                if dp[i + 1][j] > k {
                    res.push('V');
                    i += 1;
                } else {
                    k -= dp[i + 1][j];
                    res.push('H');
                    j += 1;
                }
            }
        }
        res
    }
}