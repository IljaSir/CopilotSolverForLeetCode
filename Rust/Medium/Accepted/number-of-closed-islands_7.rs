impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut count = 0;

        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 0 {
                    if Self::dfs(&mut grid, i, j) {
                        count += 1;
                    }
                }
            }
        }

        count
    }

    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> bool {
        if i == 0 || i == grid.len() - 1 || j == 0 || j == grid[i].len() - 1 {
            return false;
        }

        if grid[i][j] == 1 {
            return true;
        }

        grid[i][j] = 1;

        let mut ret = true;

        for (x, y) in &[(1, 0), (-1, 0), (0, 1), (0, -1)] {
            let x = i as i32 + x;
            let y = j as i32 + y;

            if x < 0 || y < 0 || x >= grid.len() as i32 || y >= grid[i].len() as i32 {
                continue;
            }

            if grid[x as usize][y as usize] == 0 {
                ret &= Self::dfs(grid, x as usize, y as usize);
            }
        }

        ret
    }
}