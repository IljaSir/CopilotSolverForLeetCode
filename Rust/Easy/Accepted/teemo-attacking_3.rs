impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut res = 0;
        let mut last = 0;
        for t in time_series {
            if t > last {
                res += duration;
            } else {
                res += t + duration - last;
            }
            last = t + duration;
        }
        res
    }
}