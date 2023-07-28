impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = -1;
        let mut max = -1;
        let mut mean = 0.0;
        let mut median = 0.0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut sum = 0;
        let mut count_sum = 0;
        for i in 0..count.len() {
            if count[i] > 0 {
                if min == -1 {
                    min = i as i32;
                }
                max = i as i32;
                sum += i as i32 * count[i];
                if count[i] > mode_count {
                    mode = i as i32;
                    mode_count = count[i];
                }
            }
            count_sum += count[i];
        }
        mean = sum as f64 / count_sum as f64;
        let mut count_sum = 0;
        for i in 0..count.len() {
            count_sum += count[i];
            if count_sum >= count_sum / 2 {
                median = i as f64;
                if count_sum > count_sum / 2 {
                    median += 0.5;
                }
                break;
            }
        }
        vec![min as f64, max as f64, mean, median, mode as f64]
    }
}