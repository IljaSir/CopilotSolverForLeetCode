impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        for i in 0..(points.len() - 1) {
            result += (points[i][0] - points[i + 1][0]).abs().max((points[i][1] - points[i + 1][1]).abs());
        }
        result
    }
}