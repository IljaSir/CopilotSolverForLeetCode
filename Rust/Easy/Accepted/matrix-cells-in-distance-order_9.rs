impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut result: Vec<(i32, i32)> = Vec::new();
        let mut i = 0;
        while i < rows + cols {
            let mut j = 0;
            while j <= i {
                if j < rows && i - j < cols {
                    result.push((j, i - j));
                }
                j += 1;
            }
            i += 1;
        }
        result.sort_by(|a, b| {
            let d1 = (a.0 - r_center).abs() + (a.1 - c_center).abs();
            let d2 = (b.0 - r_center).abs() + (b.1 - c_center).abs();
            d1.cmp(&d2)
        });
        result
            .into_iter()
            .map(|(r, c)| vec![r, c])
            .collect::<Vec<Vec<i32>>>()
    }
}