impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let hour = hour % 12;
        let hour = hour as f64 + minutes as f64 / 60.0;
        let minutes = minutes as f64;
        let angle = (hour * 30.0 - minutes * 6.0).abs();
        if angle > 180.0 {
            return 360.0 - angle;
        }
        angle
    }
}