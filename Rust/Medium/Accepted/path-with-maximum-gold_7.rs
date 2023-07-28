impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut max_gold = 0;
        let mut visited = vec![vec![false; n]; m];
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] > 0 {
                    max_gold = max_gold.max(Self::dfs(&grid, &mut visited, i, j));
                }
            }
        }
        max_gold
    }
    fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let mut max_gold = 0;
        let dirs = vec![(-1, 0), (0, -1), (1, 0), (0, 1)];
        visited[i][j] = true;
        for (di, dj) in dirs {
            let (ni, nj) = (i as i32 + di, j as i32 + dj);
            if ni >= 0 && ni < m as i32 && nj >= 0 && nj < n as i32 {
                let (ni, nj) = (ni as usize, nj as usize);
                if !visited[ni][nj] && grid[ni][nj] > 0 {
                    max_gold = max_gold.max(Self::dfs(grid, visited, ni, nj));
                }
            }
        }
        visited[i][j] = false;
        max_gold + grid[i][j]
    }
}