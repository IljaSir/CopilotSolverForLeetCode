impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut ans = Vec::new();
        for i in 0..rows {
            for j in 0..cols {
                ans.push(vec![i, j]);
            }
        }
        ans.sort_by_key(|v| (v[0] - r_center).abs() + (v[1] - c_center).abs());
        ans
    }
}