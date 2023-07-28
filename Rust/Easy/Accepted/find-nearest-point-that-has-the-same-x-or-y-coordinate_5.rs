impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut min_idx = -1;
        for (i, p) in points.iter().enumerate() {
            if p[0] == x || p[1] == y {
                let d = (p[0] - x).abs() + (p[1] - y).abs();
                if d < min {
                    min = d;
                    min_idx = i as i32;
                }
            }
        }
        min_idx
    }
}