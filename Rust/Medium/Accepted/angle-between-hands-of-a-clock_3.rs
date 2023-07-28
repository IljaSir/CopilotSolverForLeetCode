impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let hour = hour as f64;
        let minutes = minutes as f64;
        let hour_angle = (hour % 12.0 + minutes / 60.0) * 30.0;
        let minute_angle = minutes * 6.0;
        let angle = (hour_angle - minute_angle).abs();
        if angle > 180.0 {
            360.0 - angle
        } else {
            angle
        }
    }
}