impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let (x, y) = (coordinates[0][0], coordinates[0][1]);
        let (dx, dy) = (coordinates[1][0] - x, coordinates[1][1] - y);
        for i in 2..coordinates.len() {
            let (x, y) = (coordinates[i][0], coordinates[i][1]);
            if dx * (y - coordinates[0][1]) != dy * (x - coordinates[0][0]) {
                return false;
            }
        }
        true
    }
}