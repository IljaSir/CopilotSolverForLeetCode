impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        for i in 1..points.len() {
            let (x1, y1) = (points[i-1][0], points[i-1][1]);
            let (x2, y2) = (points[i][0], points[i][1]);
            ans += (x2-x1).abs().max((y2-y1).abs());
        }
        ans
    }
}