impl Solution {
    pub fn spiral_matrix_iii(rows: i32, cols: i32, r_start: i32, c_start: i32) -> Vec<Vec<i32>> {
        
        let mut r = Vec::new();
        let mut d = 0;
        let mut x = r_start;
        let mut y = c_start;
        let mut n = 1;
        let mut m = 0;
        r.push(vec![x, y]);
        while r.len() < (rows * cols) as usize {
            for _ in 0..2 {
                for _ in 0..n {
                    match d {
                        0 => y += 1,
                        1 => x += 1,
                        2 => y -= 1,
                        3 => x -= 1,
                        _ => (),
                    }
                    if x >= 0 && y >= 0 && x < rows && y < cols {
                        r.push(vec![x, y]);
                    }
                }
                d = (d + 1) % 4;
            }
            n += 1;
        }
        r
    }
}