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
        if x1 == x2 && y1 == y2 {
            return false;
        }
        if x2 == x3 && y2 == y3 {
            return false;
        }
        if x3 == x1 && y3 == y1 {
            return false;
        }
        if x1 == x2 {
            return true;
        }
        if x2 == x3 {
            return true;
        }
        if x3 == x1 {
            return true;
        }
        let m1 = (y2 - y1) as f64 / (x2 - x1) as f64;
        let m2 = (y3 - y2) as f64 / (x3 - x2) as f64;
        return m1 != m2;
    }
}