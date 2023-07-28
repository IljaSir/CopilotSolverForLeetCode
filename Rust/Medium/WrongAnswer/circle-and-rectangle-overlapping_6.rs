impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let x = (x_center - x1).max(x2 - x_center).max(0);
        let y = (y_center - y1).max(y2 - y_center).max(0);
        x * x + y * y <= radius * radius
    }
}