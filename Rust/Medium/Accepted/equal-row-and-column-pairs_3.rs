impl Solution {
    pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut row = vec![0; n];
        let mut col = vec![0; n];
        for i in 0..n {
            for j in 0..n {
                row[i] = row[i] * 100_001 + grid[i][j];
                col[j] = col[j] * 100_001 + grid[i][j];
            }
        }
        let mut res = 0;
        for i in 0..n {
            for j in 0..n {
                if row[i] == col[j] {
                    res += 1;
                }
            }
        }
        res
    }
}