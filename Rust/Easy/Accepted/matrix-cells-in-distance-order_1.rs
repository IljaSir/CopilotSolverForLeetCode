impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut cells = Vec::new();
        for r in 0..rows {
            for c in 0..cols {
                cells.push(vec![r, c]);
            }
        }
        cells.sort_by(|a, b| {
            let d1 = (a[0] - r_center).abs() + (a[1] - c_center).abs();
            let d2 = (b[0] - r_center).abs() + (b[1] - c_center).abs();
            d1.cmp(&d2)
        });
        cells
    }
}