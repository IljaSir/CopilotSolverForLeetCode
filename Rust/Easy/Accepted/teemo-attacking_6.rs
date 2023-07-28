impl Solution {
    pub fn find_poisoned_duration(time_series: Vec<i32>, duration: i32) -> i32 {
        
        let mut time = 0;
        for i in 0..time_series.len() {
            if i == 0 {
                time += duration;
            } else {
                let t = time_series[i] - time_series[i - 1];
                if t >= duration {
                    time += duration;
                } else {
                    time += t;
                }
            }
        }
        time
    }
}