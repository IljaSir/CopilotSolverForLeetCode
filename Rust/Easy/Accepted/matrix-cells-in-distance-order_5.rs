impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut result = vec![vec![]; (rows + cols) as usize];
        for r in 0..rows {
            for c in 0..cols {
                result[(r - r_center).abs() as usize + (c - c_center).abs() as usize].push(vec![r, c]);
            }
        }
        result.into_iter().flatten().collect()
    }
}