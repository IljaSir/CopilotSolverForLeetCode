impl Solution {
    pub fn is_boomerang(points: Vec<Vec<i32>>) -> bool {
        
        let mut is_boomerang = true;
        let mut x1 = points[0][0];
        let mut x2 = points[1][0];
        let mut x3 = points[2][0];
        let mut y1 = points[0][1];
        let mut y2 = points[1][1];
        let mut y3 = points[2][1];
        
        if (x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3) {
            is_boomerang = false;
        } else if (x1 - x2) * (y1 - y3) == (x1 - x3) * (y1 - y2) {
            is_boomerang = false;
        }
        
        is_boomerang
    }
}