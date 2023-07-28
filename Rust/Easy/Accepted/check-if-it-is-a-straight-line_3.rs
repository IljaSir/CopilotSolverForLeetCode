impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        
        let x1 = coordinates[0][0];
        let y1 = coordinates[0][1];
        let x2 = coordinates[1][0];
        let y2 = coordinates[1][1];
        for i in 2..coordinates.len() {
            let x = coordinates[i][0];
            let y = coordinates[i][1];
            if (x - x1) * (y2 - y1) != (x2 - x1) * (y - y1) {
                return false;
            }
        }
        true
    }
}