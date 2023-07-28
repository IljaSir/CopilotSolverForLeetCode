impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let mut m = minutes as f64;
        let mut h = hour as f64;
        h += m / 60.0;
        m *= 6.0;
        h *= 30.0;
        let mut angle = (m - h).abs();
        if angle > 180.0 {
            angle = 360.0 - angle;
        }
        angle
    }
}