impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        
        let mut alt = 0;
        let mut max = 0;
        for i in &gain {
            alt += i;
            if alt > max {
                max = alt;
            }
        }
        max
    }
}