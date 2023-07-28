impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let h = (hour % 12) as f64 + (minutes as f64 / 60.0);
        let m = minutes as f64;
        let angle = (h - m / 5.0).abs() * 30.0;
        if angle > 180.0 {
            360.0 - angle
        } else {
            angle
        }
    }
}