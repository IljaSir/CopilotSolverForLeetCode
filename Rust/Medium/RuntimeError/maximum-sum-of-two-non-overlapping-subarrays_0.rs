impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut res = 0;
        let (first_len, second_len) = (first_len as usize, second_len as usize);
        for i in 0..=n - first_len {
            let first = sum[i + first_len] - sum[i];
            let mut second = 0;
            second = second.max(sum[i] + sum[n] - sum[i + first_len] - sum[i]);
            second = second.max(sum[i + first_len] + sum[n] - sum[i + first_len + second_len] - sum[i + first_len]);
            res = res.max(first + second);
        }
        res
    }
}