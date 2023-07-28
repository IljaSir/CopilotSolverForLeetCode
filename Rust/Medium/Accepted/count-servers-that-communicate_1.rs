impl Solution {
    pub fn count_servers(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut row = vec![0; grid.len()];
        let mut col = vec![0; grid[0].len()];
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        let mut res = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 && (row[i] > 1 || col[j] > 1) {
                    res += 1;
                }
            }
        }
        res
    }
}