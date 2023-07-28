impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = 0;
        let mut max = 0;
        let mut sum = 0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0.0;
        let mut median_count = 0;
        let mut median_count_max = 0;
        let mut median_count_min = 0;
        let mut median_count_min_found = false;
        let mut count_sum = 0;
        let mut count_sum_max = 0;
        let mut count_sum_min = 0;
        let mut count_sum_min_found = false;
        for (i, c) in count.iter().enumerate() {
            if *c > 0 {
                if !count_sum_min_found {
                    count_sum_min = count_sum;
                    median_count_min = median_count;
                    median_count_min_found = true;
                }
                count_sum_max = count_sum;
                median_count_max = median_count;
                min = i as i32;
                max = i as i32;
                sum += i as i32 * c;
                if *c > mode_count {
                    mode_count = *c;
                    mode = i as i32;
                }
            }
            count_sum += c;
            median_count += c;
            if count_sum == count_sum_max / 2 && !median_count_min_found {
                median_count_min = median_count;
                count_sum_min = count_sum;
                median_count_min_found = true;
            }
            if count_sum == count_sum_max / 2 + 1 {
                median_count_max = median_count;
                count_sum_max = count_sum;
            }
        }
        if count_sum_max % 2 == 1 {
            median = mode as f64;
        } else {
            median = (median_count_max + median_count_min) as f64 / 2.0;
        }
        vec![
            min as f64,
            max as f64,
            sum as f64 / count_sum as f64,
            median,
            mode as f64,
        ]
    }
}