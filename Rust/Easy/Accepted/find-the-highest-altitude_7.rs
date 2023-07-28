impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for i in gain {
            cur += i;
            max = max.max(cur);
        }
        max
    }
}