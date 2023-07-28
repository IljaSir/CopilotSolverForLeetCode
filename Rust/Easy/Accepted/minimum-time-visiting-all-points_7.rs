impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut total = 0;
        for i in 1..points.len() {
            let (x, y) = (points[i][0] - points[i-1][0], points[i][1] - points[i-1][1]);
            total += x.abs().max(y.abs());
        }
        total
    }
}