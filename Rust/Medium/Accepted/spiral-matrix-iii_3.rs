impl Solution {
    pub fn spiral_matrix_iii(rows: i32, cols: i32, r_start: i32, c_start: i32) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut x = r_start;
        let mut y = c_start;
        res.push(vec![x, y]);
        let mut step = 1;
        let mut dx = 0;
        let mut dy = 1;
        while res.len() < (rows * cols) as usize {
            for _ in 0..2 {
                for _ in 0..step {
                    x += dx;
                    y += dy;
                    if x >= 0 && x < rows && y >= 0 && y < cols {
                        res.push(vec![x, y]);
                    }
                }
                std::mem::swap(&mut dx, &mut dy);
                dy = -dy;
            }
            step += 1;
        }
        res
    }
}