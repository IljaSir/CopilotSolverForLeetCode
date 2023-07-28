impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut grid = grid;
        let (n, m) = (grid.len(), grid[0].len());
        for i in 0..n {
            for j in 0..m {
                if grid[i][j] == 0 && Self::dfs(i, j, &mut grid) {
                    count += 1;
                }
            }
        }
        count
    }

    fn dfs(x: usize, y: usize, grid: &mut Vec<Vec<i32>>) -> bool {
        let (n, m) = (grid.len(), grid[0].len());
        if x < 0 || x >= n || y < 0 || y >= m {
            return false;
        }
        if grid[x][y] == 1 {
            return true;
        }
        grid[x][y] = 1;
        let mut res = true;
        for (dx, dy) in vec![(1, 0), (0, 1), (-1, 0), (0, -1)] {
            let nx = x as i32 + dx;
            let ny = y as i32 + dy;
            if nx >= 0 && nx < n as i32 && ny >= 0 && ny < m as i32 {
                res &= Self::dfs(nx as usize, ny as usize, grid);
            }
        }
        res
    }
}