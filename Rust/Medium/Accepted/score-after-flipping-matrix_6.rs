impl Solution {
    pub fn matrix_score(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut ans = 0;
        for i in 0..grid.len() {
            if grid[i][0] == 0 {
                for j in 0..grid[i].len() {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for j in 0..grid[0].len() {
            let mut cnt = 0;
            for i in 0..grid.len() {
                if grid[i][j] == 1 {
                    cnt += 1;
                }
            }
            ans += (1 << (grid[0].len() - j - 1)) * std::cmp::max(cnt, grid.len() - cnt) as i32;
        }
        ans
    }
}