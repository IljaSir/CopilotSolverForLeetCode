impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut time = 0;
        for i in 1..points.len() {
            let dif_x = (points[i][0] - points[i - 1][0]).abs();
            let dif_y = (points[i][1] - points[i - 1][1]).abs();
            time += dif_x.max(dif_y);
        }
        time
    }
}