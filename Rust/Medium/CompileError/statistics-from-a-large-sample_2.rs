impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = 0;
        let mut max = 0;
        let mut mean = 0;
        let mut median = 0;
        let mut mode = 0;
        
        let mut sum = 0;
        let mut count_sum = 0;
        let mut mode_count = 0;
        let mut count_sum_half = 0;
        let mut median1 = 0;
        let mut median2 = 0;
        
        for i in 0..count.len() {
            if count[i] > 0 {
                if min == 0 {
                    min = i as i32;
                }
                max = i as i32;
                sum += count[i] * (i as i32);
                count_sum += count[i];
                if count[i] > mode_count {
                    mode_count = count[i];
                    mode = i as i32;
                }
            }
        }
        mean = sum / count_sum;
        
        if count_sum % 2 == 0 {
            count_sum_half = count_sum / 2;
            for i in 0..count.len() {
                if count[i] > 0 {
                    if count_sum_half - count[i] >= 0 {
                        count_sum_half -= count[i];
                    } else if count_sum_half - count[i] < 0 {
                        median1 = i as i32;
                        break;
                    }
                }
            }
            for i in 0..count.len() {
                if count[i] > 0 {
                    if count_sum_half - count[i] >= 0 {
                        count_sum_half -= count[i];
                    } else if count_sum_half - count[i] < 0 {
                        median2 = i as i32;
                        break;
                    }
                }
            }
            median = (median1 + median2) / 2;
        } else {
            count_sum_half = count_sum / 2 + 1;
            for i in 0..count.len() {
                if count[i] > 0 {
                    if count_sum_half - count[i] > 0 {
                        count_sum_half -= count[i];
                    } else if count_sum_half - count[i] <= 0 {
                        median = i as i32;
                        break;
                    }
                }
            }
        }
        
        vec![min as f64, max as f64, mean as f64, median as f
    }
}