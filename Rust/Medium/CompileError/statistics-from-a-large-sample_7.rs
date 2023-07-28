impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = 0;
        let mut max = 0;
        let mut sum = 0;
        let mut count = count;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0;
        let mut median_count = 0;
        let mut median_idx = 0;
        let mut median_idx2 = 0;
        let mut total = 0;
        for i in 0..count.len() {
            if count[i] > 0 {
                min = i as i32;
                break;
            }
        }
        for i in (0..count.len()).rev() {
            if count[i] > 0 {
                max = i as i32;
                break;
            }
        }
        for i in 0..count.len() {
            if count[i] > 0 {
                if count[i] > mode_count {
                    mode = i as i32;
                    mode_count = count[i];
                }
                sum += i as i32 * count[i];
                total += count[i];
            }
        }
        if total % 2 == 1 {
            median_count = total / 2 + 1;
        } else {
            median_count = total / 2;
        }
        for i in 0..count.len() {
            if count[i] > 0 {
                median_idx += count[i];
                if median_idx >= median_count {
                    median_idx2 = i as i32;
                    if median_count * 2 == total {
                        median = (median_idx2 + median) as f64 / 2.0;
                    } else {
                        median = median_idx2 as f64;
                    }
                    break;
                }
                median = i as i32;
            }
        }
        return vec![
            min as f64,
            max as f64,
            sum as f64 / total as f64,
            median,
            mode as f64,
        ];
    }
}