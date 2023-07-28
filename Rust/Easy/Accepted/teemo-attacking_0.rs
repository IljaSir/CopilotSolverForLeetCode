impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..time_series.len() {
            res += time_series[i].min(time_series[i - 1] + duration) - time_series[i - 1];
        }
        if !time_series.is_empty() {
            res += duration;
        }
        res
    }
}