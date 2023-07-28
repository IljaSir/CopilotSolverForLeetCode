impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut time = 0;
        let mut last = 0;
        for t in time_series {
            if t >= last {
                time += duration;
            } else {
                time += t + duration - last;
            }
            last = t + duration;
        }
        time
    }
}