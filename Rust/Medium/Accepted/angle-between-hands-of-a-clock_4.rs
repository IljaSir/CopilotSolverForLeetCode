impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let mut hour = hour;
        if hour == 12 {
            hour = 0;
        }
        let hour_angle = (hour as f64) * 30.0 + (minutes as f64) * 0.5;
        let minutes_angle = (minutes as f64) * 6.0;
        let mut angle = (hour_angle - minutes_angle).abs();
        if angle > 180.0 {
            angle = 360.0 - angle;
        }
        angle
    }
}