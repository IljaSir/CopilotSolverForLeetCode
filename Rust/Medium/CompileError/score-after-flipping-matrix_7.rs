impl Solution {
    pub fn matrix_score(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let (m, n) = (grid.len(), grid[0].len());
        let mut ans = 0;
        for i in 0..m {
            if grid[i][0] == 0 {
                for j in 0..n {
                    grid[i][j] = if grid[i][j] == 0 { 1 } else { 0 };
                }
            }
        }
        for j in 0..n {
            let mut cnt = 0;
            for i in 0..m {
                if grid[i][j] == 1 {
                    cnt += 1;
                }
            }
            ans += (1 << (n - j - 1)) * cmp::max(cnt, m - cnt);
        }
        ans as i32
    }
}