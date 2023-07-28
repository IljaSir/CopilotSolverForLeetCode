impl Solution {
    pub fn rotate_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut i = 0;
        let mut j = 0;
        let mut k = k;
        while i < m / 2 && j < n / 2 {
            let mut x = i;
            let mut y = j;
            let mut len = (m - 2 * i) * 2 + (n - 2 * j) * 2 - 4;
            k %= len;
            while k > 0 {
                let tmp = grid[x][y];
                if x == i && y < n - 1 - j {
                    grid[x][y] = grid[x][y + 1];
                    y += 1;
                } else if y == n - 1 - j && x < m - 1 - i {
                    grid[x][y] = grid[x + 1][y];
                    x += 1;
                } else if x == m - 1 - i && y > j {
                    grid[x][y] = grid[x][y - 1];
                    y -= 1;
                } else if y == j && x > i {
                    grid[x][y] = grid[x - 1][y];
                    x -= 1;
                }
                k -= 1;
            }
            grid[x][y] = grid[i][j];
            i += 1;
            j += 1;
        }
        grid
    }
}