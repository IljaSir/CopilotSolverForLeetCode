impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let (x1, y1, x2, y2, x_center, y_center) = (x1 as f32, y1 as f32, x2 as f32, y2 as f32, x_center as f32, y_center as f32);
        let (x, y) = (x_center.max(x1).min(x2), y_center.max(y1).min(y2));
        let (x, y) = (x_center - x, y_center - y);
        (x * x + y * y) <= (radius * radius) as f32
    }
}