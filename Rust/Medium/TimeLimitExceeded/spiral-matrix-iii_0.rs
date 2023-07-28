impl Solution {
    pub fn spiral_matrix_iii(rows: i32, cols: i32, r_start: i32, c_start: i32) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let rows = rows as usize;
        let cols = cols as usize;
        let r_start = r_start as usize;
        let c_start = c_start as usize;
        let mut i = 0;
        let mut j = 0;
        let mut dir = 0;
        let mut steps = 1;
        let mut count = 0;
        let mut r = r_start;
        let mut c = c_start;
        while count < rows * cols {
            if r < rows && c < cols {
                res.push(vec![r as i32, c as i32]);
                count += 1;
            }
            if dir % 2 == 0 {
                i += 1;
            } else {
                j += 1;
            }
            if i == steps {
                dir += 1;
                i = 0;
            }
            if j == steps {
                dir += 1;
                j = 0;
                steps += 1;
            }
            dir %= 4;
            match dir {
                0 => { c += 1; }
                1 => { r += 1; }
                2 => { c -= 1; }
                3 => { r -= 1; }
                _ => unreachable!(),
            }
        }
        res
    }
}