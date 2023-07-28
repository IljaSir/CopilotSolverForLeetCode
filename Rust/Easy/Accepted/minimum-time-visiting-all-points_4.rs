impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut time = 0;
        for i in 0..points.len() - 1 {
            let x = (points[i][0] - points[i + 1][0]).abs();
            let y = (points[i][1] - points[i + 1][1]).abs();
            time += x.max(y);
        }
        time
    }
}