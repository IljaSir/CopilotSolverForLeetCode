impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut max = 0;
        let mut min = 255;
        let mut sum = 0;
        let mut count_sum = 0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0.0;
        for i in 0..255 {
            if count[i as usize] > 0 {
                if i < min {
                    min = i;
                }
                if i > max {
                    max = i;
                }
                sum += i * count[i as usize];
                count_sum += count[i as usize];
                if count[i as usize] > mode_count {
                    mode_count = count[i as usize];
                    mode = i;
                }
            }
        }
        let mut count_sum2 = 0;
        for i in 0..255 {
            if count[i as usize] > 0 {
                count_sum2 += count[i as usize];
                if count_sum2 >= count_sum / 2 {
                    if count_sum % 2 == 0 && count_sum2 == count_sum / 2 {
                        median = (i + i + 1) as f64 / 2.0;
                    } else {
                        median = i as f64;
                    }
                    break;
                }
            }
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