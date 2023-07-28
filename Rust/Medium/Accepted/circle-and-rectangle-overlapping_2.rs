impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let x1 = x1 as f64;
        let y1 = y1 as f64;
        let x2 = x2 as f64;
        let y2 = y2 as f64;
        let x_center = x_center as f64;
        let y_center = y_center as f64;
        let radius = radius as f64;
        let (x, y) = (
            x_center.max(x1).min(x2),
            y_center.max(y1).min(y2),
        );
        (x_center - x).powi(2) + (y_center - y).powi(2) <= radius.powi(2)
    }
}