impl Solution {
    pub fn matrix_score(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        for row in &mut grid {
            if row[0] == 0 {
                for i in 0..row.len() {
                    row[i] ^= 1;
                }
            }
        }
        for i in 1..grid[0].len() {
            let mut count = 0;
            for row in &grid {
                if row[i] == 1 {
                    count += 1;
                }
            }
            if count < grid.len() - count {
                for row in &mut grid {
                    row[i] ^= 1;
                }
            }
        }
        let mut ans = 0;
        for row in grid {
            let mut sum = 0;
            for i in 0..row.len() {
                sum = sum * 2 + row[i];
            }
            ans += sum;
        }
        ans
    }
}