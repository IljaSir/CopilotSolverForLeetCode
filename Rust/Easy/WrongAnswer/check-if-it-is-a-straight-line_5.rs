impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let (x1, y1) = (coordinates[0][0], coordinates[0][1]);
        let (x2, y2) = (coordinates[1][0], coordinates[1][1]);
        let mut slope = 0.0;
        if x1 != x2 {
            slope = (y1 - y2) as f64 / (x1 - x2) as f64;
        }
        for i in 2..coordinates.len() {
            let (x, y) = (coordinates[i][0], coordinates[i][1]);
            if x == x1 {
                if x != x2 {
                    return false;
                }
            } else if (y - y1) as f64 / (x - x1) as f64 != slope {
                return false;
            }
        }
        true
    }
}