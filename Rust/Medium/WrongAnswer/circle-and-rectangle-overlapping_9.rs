impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let x = x_center - x1;
        let y = y_center - y1;
        let x = if x > 0 { x } else { -x };
        let y = if y > 0 { y } else { -y };
        if x > radius && y > radius {
            let x = x - radius;
            let y = y - radius;
            let x = x * x;
            let y = y * y;
            let r = radius * radius;
            return x + y <= r;
        }
        if x > radius {
            let x = x - radius;
            let x = x * x;
            let r = radius * radius;
            return x <= r;
        }
        if y > radius {
            let y = y - radius;
            let y = y * y;
            let r = radius * radius;
            return y <= r;
        }
        true
    }
}