impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let x_center = x_center as f64;
        let y_center = y_center as f64;
        let x1 = x1 as f64;
        let y1 = y1 as f64;
        let x2 = x2 as f64;
        let y2 = y2 as f64;
        let dist_x = (x_center - x1).max(0.).min(x2 - x_center);
        let dist_y = (y_center - y1).max(0.).min(y2 - y_center);
        dist_x * dist_x + dist_y * dist_y <= (radius * radius) as f64
    }
}