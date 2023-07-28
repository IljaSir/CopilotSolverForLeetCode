impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut max_sum = 0;
        let mut min_sum = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum);
            min = std::cmp::min(min, sum);
            max_sum = std::cmp::max(max_sum, max - min);
        }
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut max_sum2 = 0;
        let mut min_sum2 = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum);
            min = std::cmp::min(min, sum);
            max_sum2 = std::cmp::max(max_sum2, max - min);
        }
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut max_sum3 = 0;
        let mut min_sum3 = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum);
            min = std::cmp::min(min, sum);
            max_sum3 = std::cmp::max(max_sum3, max - min);
        }
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut max_sum4 = 0;
        let mut min_sum4 = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum);
            min = std::cmp::min(min, sum);
            max_sum4 = std::cmp::max(max_sum4, max - min);
        }
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut max_sum5 = 0;
        let mut min_sum5 = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum);
            min = std::cmp::min(min,
    }
}