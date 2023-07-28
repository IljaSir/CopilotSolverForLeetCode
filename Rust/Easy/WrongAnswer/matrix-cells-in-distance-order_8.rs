impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut d = 0;
        let r_center = r_center as usize;
        let c_center = c_center as usize;
        while res.len() < rows as usize * cols as usize {
            let mut i = if r_center >= d { r_center - d } else { 0 };
            let mut j = if c_center >= d { c_center - d } else { 0 };
            while i <= (r_center + d) && i < rows as usize {
                while j <= (c_center + d) && j < cols as usize {
                    res.push(vec![i as i32, j as i32]);
                    j += 1;
                }
                j = if c_center >= d { c_center - d } else { 0 };
                i += 1;
            }
            d += 1;
        }
        res
    }
}