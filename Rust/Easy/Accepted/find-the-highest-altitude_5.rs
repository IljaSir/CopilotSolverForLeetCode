impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut sum = 0;
        for i in gain.iter() {
            sum += i;
            if sum > max {
                max = sum;
            }
        }
        max
    }
}