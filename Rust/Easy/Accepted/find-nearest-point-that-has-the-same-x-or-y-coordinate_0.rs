impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut res = -1;
        for (i, p) in points.iter().enumerate() {
            if p[0] == x || p[1] == y {
                let d = (x - p[0]).abs() + (y - p[1]).abs();
                if d < min {
                    min = d;
                    res = i as i32;
                }
            }
        }
        res
    }
}