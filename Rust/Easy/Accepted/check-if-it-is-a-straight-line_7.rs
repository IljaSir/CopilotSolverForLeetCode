impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let len = coordinates.len();
        let (x0, y0) = (coordinates[0][0], coordinates[0][1]);
        let (x1, y1) = (coordinates[1][0], coordinates[1][1]);
        for i in 2..len {
            let (x, y) = (coordinates[i][0], coordinates[i][1]);
            if (y - y0) * (x1 - x0) != (x - x0) * (y1 - y0) {
                return false;
            }
        }
        true
    }
}