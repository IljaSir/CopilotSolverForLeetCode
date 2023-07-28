impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut res = -1;
        let mut mn = 1 << 30;
        for i in 0..points.len() {
            let (a, b) = (points[i][0], points[i][1]);
            if a != x && b != y {
                continue;
            }
            let dist = (a - x).abs() + (b - y).abs();
            if dist < mn || (dist == mn && i < res as usize) {
                mn = dist;
                res = i as i32;
            }
        }
        res
    }
}