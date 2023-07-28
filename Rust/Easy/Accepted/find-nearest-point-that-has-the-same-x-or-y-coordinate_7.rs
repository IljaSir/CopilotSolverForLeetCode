impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut idx = -1;
        for (i, p) in points.iter().enumerate() {
            let dx = (x - p[0]).abs();
            let dy = (y - p[1]).abs();
            if dx == 0 || dy == 0 {
                let d = dx + dy;
                if d < min {
                    min = d;
                    idx = i as i32;
                }
            }
        }
        idx
    }
}