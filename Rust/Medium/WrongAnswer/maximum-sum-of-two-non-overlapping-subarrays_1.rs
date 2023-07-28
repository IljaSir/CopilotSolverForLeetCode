impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let first_len = first_len as usize;
        let second_len = second_len as usize;
        let mut sum = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut max = 0;
        for i in first_len..=nums.len() {
            let first_sum = sum[i] - sum[i - first_len];
            let mut max_second_sum = 0;
            if i > first_len {
                max_second_sum = sum[i - first_len] - sum[0];
            }
            if i + second_len <= nums.len() {
                max_second_sum = max_second_sum.max(sum[i + second_len] - sum[i]);
            }
            max = max.max(first_sum + max_second_sum);
        }
        for i in second_len..=nums.len() {
            let second_sum = sum[i] - sum[i - second_len];
            let mut max_first_sum = 0;
            if i > second_len {
                max_first_sum = sum[i - second_len] - sum[0];
            }
            if i + first_len <= nums.len() {
                max_first_sum = max_first_sum.max(sum[i + first_len] - sum[i]);
            }
            max = max.max(second_sum + max_first_sum);
        }
        max
    }
}