impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let mut h = (hour as f64) * 30.0 + (minutes as f64) * 0.5;
        let m = (minutes as f64) * 6.0;
        let mut ret = (h - m).abs();
        if ret > 180.0 {
            ret = 360.0 - ret;
        }
        ret
    }
}