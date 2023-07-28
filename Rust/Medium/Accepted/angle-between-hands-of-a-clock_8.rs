impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let hour = hour % 12;
        let mut angle = (hour as f64 * 30.0 + minutes as f64 * 0.5) - minutes as f64 * 6.0;
        if angle < 0.0 {
            angle = -angle;
        }
        if angle > 180.0 {
            angle = 360.0 - angle;
        }
        angle
    }
}