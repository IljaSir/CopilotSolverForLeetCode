impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut total = 0;
        let mut start = 0;
        let mut end = 0;
        for time in time_series {
            if time >= end {
                total += end - start;
                start = time;
            }
            end = time + duration;
        }
        total + end - start
    }
}