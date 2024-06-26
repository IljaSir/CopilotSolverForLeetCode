impl Solution {
    pub fn visible_points(points: Vec<Vec<i32>>, angle: i32, location: Vec<i32>) -> i32 {
        
        let mut angles: Vec<f64> = points
            .iter()
            .map(|p| {
                let mut angle = (p[1] - location[1]) as f64 / (p[0] - location[0]) as f64;
                if angle.is_nan() {
                    angle = std::f64::INFINITY;
                }
                angle
            })
            .collect();
        let mut count = points
            .iter()
            .filter(|p| p[0] == location[0] && p[1] == location[1])
            .count() as i32;
        angles.sort_by(|a, b| a.partial_cmp(b).unwrap());
        angles.extend(angles.iter().map(|a| a + 2.0 * std::f64::consts::PI));
        let mut res = 0;
        let angle = angle as f64 * std::f64::consts::PI / 180.0;
        let mut j = 0;
        for i in 0..angles.len() {
            while angles[i] - angles[j] > angle {
                j += 1;
            }
            res = res.max(i - j + 1);
        }
        res as i32 + count
    }
}