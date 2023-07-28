impl Solution {
    pub fn unique_paths_with_obstacles(obstacle_grid: Vec<Vec<i32>>) -> i32 {
        

        let m = obstacle_grid.len();
        let n = obstacle_grid[0].len();
        if obstacle_grid[m - 1][n - 1] == 1 {
            return 0;
        }
        let mut path = vec![vec![0; n]; m];
        path[m - 1][n - 1] = 1;
        for i in (0..m).rev() {
            for j in (0..n).rev() {
                if obstacle_grid[i][j] == 1 {
                    path[i][j] = 0;
                } else if i == m - 1 && j == n - 1 {
                    path[i][j] = 1;
                } else if i == m - 1 {
                    path[i][j] = path[i][j + 1];
                } else if j == n - 1 {
                    path[i][j] = path[i + 1][j];
                } else {
                    path[i][j] = path[i][j + 1] + path[i + 1][j];
                }
            }
        }
        path[0][0]
    }
}