impl Solution {
    pub fn sample_stats(count: Vec<i32>) -> Vec<f64> {
        
        let mut min = 0;
        let mut max = 0;
        let mut sum = 0;
        let mut mode = 0;
        let mut mode_count = 0;
        let mut median = 0.0;
        let mut median_count = 0;
        let mut count_sum = 0;
        let mut count_sum_2 = 0;
        for i in 0..256 {
            if count[i as usize] > 0 {
                min = i;
                break;
            }
        }
        for i in (0..256).rev() {
            if count[i as usize] > 0 {
                max = i;
                break;
            }
        }
        for i in 0..256 {
            sum += i * count[i as usize];
            if count[i as usize] > mode_count {
                mode = i;
                mode_count = count[i as usize];
            }
            count_sum += count[i as usize];
            if count_sum >= count_sum_2 + count_sum / 2 {
                median += i as f64;
                count_sum_2 += count_sum;
            }
        }
        median /= (count_sum_2 / 2) as f64;
        vec![
            min as f64,
            max as f64,
            sum as f64 / count_sum as f64,
            median,
            mode as f64,
        ]
    }
}