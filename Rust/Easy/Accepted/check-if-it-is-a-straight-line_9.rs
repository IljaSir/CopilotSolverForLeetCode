impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let mut pre_slope = None;
        for i in 1..coordinates.len() {
            let x1 = coordinates[i-1][0];
            let x2 = coordinates[i][0];
            let y1 = coordinates[i-1][1];
            let y2 = coordinates[i][1];
            if x1 == x2 {
                if pre_slope.is_some() && pre_slope.unwrap() != f64::INFINITY {
                    return false;
                }
                pre_slope = Some(f64::INFINITY);
            } else {
                let slope = (y2 - y1) as f64 / (x2 - x1) as f64;
                if pre_slope.is_some() && pre_slope.unwrap() != slope {
                    return false;
                }
                pre_slope = Some(slope);
            }
        }
        true
    }
}