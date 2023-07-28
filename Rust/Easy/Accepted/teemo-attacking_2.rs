impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut ans = 0;
        for i in 1..time_series.len() {
            ans += time_series[i].min(time_series[i-1] + duration) - time_series[i-1];
        }
        ans + duration
    }
}