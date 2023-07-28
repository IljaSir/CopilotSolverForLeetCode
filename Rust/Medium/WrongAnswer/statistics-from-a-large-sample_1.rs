impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = 255;
        let mut max = 0;
        let mut sum = 0;
        let mut count_sum = 0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0.0;
        for (i, &c) in count.iter().enumerate() {
            if c > 0 {
                min = i;
                break;
            }
        }
        for (i, &c) in count.iter().enumerate().rev() {
            if c > 0 {
                max = i;
                break;
            }
        }
        for (i, &c) in count.iter().enumerate() {
            if c > 0 {
                sum += i * c as usize;
                count_sum += c as usize;
                if c > mode_count {
                    mode_count = c;
                    mode = i;
                }
            }
        }
        let mut median_count = 0;
        if count_sum % 2 == 0 {
            let mut first = 0;
            for (i, &c) in count.iter().enumerate() {
                if c > 0 {
                    median_count += c as usize;
                    if median_count >= count_sum / 2 {
                        first = i;
                        break;
                    }
                }
            }
            let mut second = 0;
            for (i, &c) in count.iter().enumerate() {
                if c > 0 {
                    median_count += c as usize;
                    if median_count >= count_sum / 2 + 1 {
                        second = i;
                        break;
                    }
                }
            }
            median = (first + second) as f64 / 2f64;
        } else {
            for (i, &c) in count.iter().enumerate() {
                if c > 0 {
                    median_count += c as usize;
                    if median_count > count_sum / 2 {
                        median = i as f64;
                        break;
                    }
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