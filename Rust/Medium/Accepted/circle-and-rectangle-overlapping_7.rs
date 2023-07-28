impl Solution {
    pub fn check_overlap(radius: i32, x_center: i32, y_center: i32, x1: i32, y1: i32, x2: i32, y2: i32) -> bool {
        
        let (x, y) = (x_center as f32, y_center as f32);
        let (x1, y1, x2, y2) = (x1 as f32, y1 as f32, x2 as f32, y2 as f32);
        let (xc, yc) = if x < x1 {
            (x1, if y < y1 { y1 } else if y > y2 { y2 } else { y })
        } else if x > x2 {
            (x2, if y < y1 { y1 } else if y > y2 { y2 } else { y })
        } else {
            (x, if y < y1 { y1 } else if y > y2 { y2 } else { y })
        };
        ((x - xc) * (x - xc) + (y - yc) * (y - yc)) <= (radius * radius) as f32
    }
}