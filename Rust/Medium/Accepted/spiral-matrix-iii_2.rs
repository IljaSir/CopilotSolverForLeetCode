impl Solution {
    pub fn spiral_matrix_iii(rows: i32, cols: i32, r_start: i32, c_start: i32) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        res.push(vec![r_start, c_start]);
        let mut cnt = 1;
        let mut step = 1;
        let mut r = r_start;
        let mut c = c_start;
        while cnt < rows * cols {
            for _ in 0..step {
                c += 1;
                if r >= 0 && r < rows && c >= 0 && c < cols {
                    res.push(vec![r, c]);
                    cnt += 1;
                }
            }
            for _ in 0..step {
                r += 1;
                if r >= 0 && r < rows && c >= 0 && c < cols {
                    res.push(vec![r, c]);
                    cnt += 1;
                }
            }
            step += 1;
            for _ in 0..step {
                c -= 1;
                if r >= 0 && r < rows && c >= 0 && c < cols {
                    res.push(vec![r, c]);
                    cnt += 1;
                }
            }
            for _ in 0..step {
                r -= 1;
                if r >= 0 && r < rows && c >= 0 && c < cols {
                    res.push(vec![r, c]);
                    cnt += 1;
                }
            }
            step += 1;
        }
        res
    }
}