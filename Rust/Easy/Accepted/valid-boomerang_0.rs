impl Solution {
    pub fn is_boomerang(points: Vec<Vec<i32>>) -> bool {
        
        let x1 = points[0][0];
        let y1 = points[0][1];
        let x2 = points[1][0];
        let y2 = points[1][1];
        let x3 = points[2][0];
        let y3 = points[2][1];
        
        if x1 == x2 && x2 == x3 {
            return false;
        }
        if y1 == y2 && y2 == y3 {
            return false;
        }
        if (x1-x2)*(y1-y3) == (x1-x3)*(y1-y2) {
            return false;
        }
        return true;
    }
}