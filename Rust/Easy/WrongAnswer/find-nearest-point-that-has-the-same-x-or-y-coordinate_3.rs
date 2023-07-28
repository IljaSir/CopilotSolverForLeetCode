impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut valid_points = Vec::new();
        for i in 0..points.len() {
            if points[i][0] == x || points[i][1] == y {
                valid_points.push(points[i].clone());
            }
        }
        if valid_points.is_empty() {
            return -1;
        }
        let mut min = 10000;
        let mut index = 0;
        for i in 0..valid_points.len() {
            let distance = (valid_points[i][0] - x).abs() + (valid_points[i][1] - y).abs();
            if distance < min {
                min = distance;
                index = i;
            }
        }
        index as i32
    }
}