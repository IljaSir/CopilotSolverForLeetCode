impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        for i in 0..rows {
            for j in 0..cols {
                res.push(vec![i, j]);
            }
        }
        res.sort_by_key(|x| (x[0] - r_center).abs() + (x[1] - c_center).abs());
        res
    }
}