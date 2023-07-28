impl Solution {
    pub fn is_boomerang(points: Vec<Vec<i32>>) -> bool {
        
        let (x1, y1) = (points[0][0], points[0][1]);
        let (x2, y2) = (points[1][0], points[1][1]);
        let (x3, y3) = (points[2][0], points[2][1]);
        if x1 == x2 && x2 == x3 {
            return false;
        }
        if y1 == y2 && y2 == y3 {
            return false;
        }
        if x1 == x2 {
            return true;
        }
        if y1 == y2 {
            return true;
        }
        if (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1) {
            return false;
        }
        true
    }
}