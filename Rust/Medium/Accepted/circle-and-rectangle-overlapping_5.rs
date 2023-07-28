impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let (x, y) = (x_center as f64, y_center as f64);
        let (x1, y1, x2, y2) = (x1 as f64, y1 as f64, x2 as f64, y2 as f64);
        let (x, y) = (x.max(x1).min(x2), y.max(y1).min(y2));
        (x - x_center as f64).powi(2) + (y - y_center as f64).powi(2) <= radius as f64 * radius as f64
    }
}