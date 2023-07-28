impl Solution {
    pub fn longest_increasing_path(matrix: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (matrix.len(), matrix[0].len());
        let mut dp = vec![vec![0; n]; m];
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                ans = ans.max(Solution::dfs(&matrix, i, j, &mut dp));
            }
        }
        ans
    }
    fn dfs(matrix: &Vec<Vec<i32>>, i: usize, j: usize, dp: &mut Vec<Vec<i32>>) -> i32 {
        if dp[i][j] != 0 {
            return dp[i][j];
        }
        let mut ans = 1;
        let (m, n) = (matrix.len(), matrix[0].len());
        let directions = [(1, 0), (-1, 0), (0, 1), (0, -1)];
        for (dx, dy) in directions.iter() {
            let (x, y) = (i as i32 + dx, j as i32 + dy);
            if x < 0 || y < 0 || x >= m as i32 || y >= n as i32 {
                continue;
            }
            let (x, y) = (x as usize, y as usize);
            if matrix[x][y] <= matrix[i][j] {
                continue;
            }
            ans = ans.max(Solution::dfs(matrix, x, y, dp) + 1);
        }
        dp[i][j] = ans;
        ans
    }
}