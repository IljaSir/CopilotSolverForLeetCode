impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut time = 0;
        let mut last = &points[0];
        for point in points.iter().skip(1) {
            time += (point[0] - last[0]).abs().max((point[1] - last[1]).abs());
            last = point;
        }
        time
    }
}