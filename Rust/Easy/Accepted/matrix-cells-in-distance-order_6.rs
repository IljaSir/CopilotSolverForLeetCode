impl Solution {
    pub fn all_cells_dist_order(rows: i32, cols: i32, r_center: i32, c_center: i32) -> Vec<Vec<i32>> {
        
        let mut ans = vec![];
        let mut max = 0;
        for i in 0..rows {
            for j in 0..cols {
                let dist = (i - r_center).abs() + (j - c_center).abs();
                if dist > max {
                    max = dist;
                }
            }
        }
        for dist in 0..=max {
            for i in 0..rows {
                for j in 0..cols {
                    if (i - r_center).abs() + (j - c_center).abs() == dist {
                        ans.push(vec![i, j]);
                    }
                }
            }
        }
        ans
    }
}