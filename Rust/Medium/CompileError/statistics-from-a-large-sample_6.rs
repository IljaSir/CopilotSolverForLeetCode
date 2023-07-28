impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut sum = 0;
        let mut total = 0;
        let mut min = 0;
        let mut max = 0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0;
        let mut median_count = 0;
        let mut median1 = 0;
        let mut median2 = 0;
        for i in 0..count.len() {
            let c = count[i];
            if c > 0 {
                if min == 0 {
                    min = i as i32;
                }
                max = i as i32;
                sum += c * i as i32;
                total += c;
                if c > mode_count {
                    mode = i as i32;
                    mode_count = c;
                }
                if median_count < total / 2 {
                    median1 = i as i32;
                    median_count += c;
                } else if median_count >= total / 2 && median_count < total / 2 + (total % 2) {
                    median2 = i as i32;
                    median_count += c;
                }
            }
        }
        if total % 2 == 0 {
            median = (median1 + median2) as f64 / 2.0;
        } else {
            median = median2 as f64;
        }
        vec![
            min as f64,
            max as f64,
            sum as f64 / total as f64,
            median,
            mode as f64,
        ]
    }
}