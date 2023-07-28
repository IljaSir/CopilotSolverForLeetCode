impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = -1;
        let mut min = std::i32::MAX;
        for (i, p) in points.iter().enumerate() {
            if p[0] == x || p[1] == y {
                let d = (p[0] - x).abs() + (p[1] - y).abs();
                if d < min {
                    ans = i as i32;
                    min = d;
                }
            }
        }
        ans
    }
}