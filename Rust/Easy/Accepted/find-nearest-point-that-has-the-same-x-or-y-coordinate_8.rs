impl Solution {
    pub fn nearest_valid_point(x: i32, y: i32, points: Vec<Vec<i32>>) -> i32 {
        
        let mut min = -1;
        let mut min_index = -1;
        for i in 0..points.len() {
            let p = &points[i];
            if x == p[0] || y == p[1] {
                let d = (x - p[0]).abs() + (y - p[1]).abs();
                if min == -1 || d < min {
                    min = d;
                    min_index = i as i32;
                }
            }
        }
        min_index
    }
}