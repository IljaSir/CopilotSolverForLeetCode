impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        let mut z = 0;
        for i in grid.iter() {
            let mut max = 0;
            for j in i.iter() {
                if *j > 0 {
                    z += 1;
                }
                if *j > max {
                    max = *j;
                }
            }
            y += max;
        }
        for i in 0..grid[0].len() {
            let mut max = 0;
            for j in 0..grid.len() {
                if grid[j][i] > max {
                    max = grid[j][i];
                }
            }
            x += max;
        }
        x + y + z
    }
}