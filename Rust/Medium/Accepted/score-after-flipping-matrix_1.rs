impl Solution {
    pub fn matrix_score(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        for i in 0..m {
            if grid[i][0] == 0 {
                for j in 0..n {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for j in 1..n {
            let mut cnt = 0;
            for i in 0..m {
                if grid[i][j] == 1 {
                    cnt += 1;
                }
            }
            if cnt < (m + 1) / 2 {
                for i in 0..m {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        let mut ans = 0;
        for i in 0..m {
            let mut sum = 0;
            for j in 0..n {
                sum = sum * 2 + grid[i][j];
            }
            ans += sum;
        }
        ans
    }
}