impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        
        let hour = hour % 12;
        let hour = hour as f64 + minutes as f64 / 60.0;
        let hour = hour * 30.0;
        let minutes = minutes as f64 * 6.0;
        let angle = (hour - minutes).abs();
        angle.min(360.0 - angle)
    }
}