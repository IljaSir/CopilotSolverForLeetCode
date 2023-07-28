impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let mut slope = None;
        for i in 0..coordinates.len() - 1 {
            let x1 = coordinates[i][0];
            let y1 = coordinates[i][1];
            let x2 = coordinates[i + 1][0];
            let y2 = coordinates[i + 1][1];
            let s = if x2 == x1 { 0 } else { (y2 - y1) as f64 / (x2 - x1) as f64 };
            if let Some(slope) = slope {
                if s != slope {
                    return false;
                }
            } else {
                slope = Some(s);
            }
        }
        true
    }
}