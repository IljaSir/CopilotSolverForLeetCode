impl Solution {
    pub fn minimum_average_difference(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut min = std::i32::MAX;
        let mut sum = 0;
        let mut sum1 = 0;
        let mut sum2 = 0;
        let mut n = nums.len();
        for i in 0..n {
            sum += nums[i];
        }
        for i in 0..n {
            sum1 += nums[i];
            sum2 = sum - sum1;
            let diff = (sum1 / (i+1) as i32 - sum2 / (n-i-1) as i32).abs();
            if diff < min {
                min = diff;
                res = i as i32;
            }
        }
        res
    }
}