impl Solution {
    pub fn min_days(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut grid = grid;
        let mut count = 0;
        let mut visited = vec![vec![false; n]; m];
        let mut q = std::collections::VecDeque::new();
        let mut dfs = |i: usize, j: usize| {
            if i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == 0 || visited[i][j] {
                return;
            }
            visited[i][j] = true;
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        };
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 && !visited[i][j] {
                    dfs(i, j);
                    count += 1;
                }
            }
        }
        if count != 1 {
            return 0;
        }
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    grid[i][j] = 0;
                    let mut count = 0;
                    let mut visited = vec![vec![false; n]; m];
                    for i in 0..m {
                        for j in 0..n {
                            if grid[i][j] == 1 && !visited[i][j] {
                                dfs(i, j);
                                count += 1;
                            }
                        }
                    }
                    if count != 1 {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        2
    }
}