impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = 0;
        let mut max = 0;
        let mut sum = 0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0;
        let mut median_count = 0;
        let mut total_count = 0;
        let mut odd = false;
        let mut mean = 0.0;
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
                if c > mode_count {
                    mode = i;
                    mode_count = c;
                }
                sum += i * c as usize;
                total_count += c as usize;
            }
        }
        mean = sum as f64 / total_count as f64;
        if total_count % 2 == 1 {
            odd = true;
        }
        for (i, &c) in count.iter().enumerate() {
            if c > 0 {
                median_count += c as usize;
                if odd && median_count == total_count / 2 + 1 {
                    median = i as f64;
                    break;
                } else if !odd && median_count == total_count / 2 {
                    median = i as f64;
                } else if !odd && median_count == total_count / 2 + 1 {
                    median = (median + i as f64) / 2.0;
                    break;
                }
            }
        }
        vec![(min as f64), (max as f64), mean, median, (mode as f64)]
    }
}