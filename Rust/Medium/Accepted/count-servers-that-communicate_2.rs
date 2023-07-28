impl Solution {
    pub fn count_servers(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut rows = vec![0; grid.len()];
        let mut cols = vec![0; grid[0].len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 {
                    rows[i] += 1;
                    cols[j] += 1;
                }
            }
        }
        let mut ans = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1) {
                    ans += 1;
                }
            }
        }
        ans
    }
}