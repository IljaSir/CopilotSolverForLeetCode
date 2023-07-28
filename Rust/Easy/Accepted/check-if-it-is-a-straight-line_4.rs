impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let (x1, y1) = (coordinates[0][0], coordinates[0][1]);
        let (x2, y2) = (coordinates[1][0], coordinates[1][1]);
        let a = y2 - y1;
        let b = x1 - x2;
        let c = x2 * y1 - x1 * y2;
        coordinates[2..].iter().all(|p| a * p[0] + b * p[1] + c == 0)
    }
}