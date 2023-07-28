impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut sum = 0;
        let mut last = 0;
        for &t in time_series.iter() {
            sum += duration;
            if t < last {
                sum -= last - t;
            }
            last = t + duration;
        }
        sum
    }
}