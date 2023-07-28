impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let n = nums.len();
        let first_len = first_len as usize;
        let second_len = second_len as usize;
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut ans = 0;
        for i in first_len..=n {
            ans = ans.max(sum[i] - sum[i - first_len] + sum[i - first_len - second_len..i - first_len].iter().max().unwrap_or(&0));
            ans = ans.max(sum[i] - sum[i - first_len] + sum[i - first_len..i].iter().max().unwrap_or(&0));
        }
        for i in first_len + second_len..=n {
            ans = ans.max(sum[i] - sum[i - second_len] + sum[i - second_len - first_len..i - second_len].iter().max().unwrap_or(&0));
            ans = ans.max(sum[i] - sum[i - second_len] + sum[i - second_len..i].iter().max().unwrap_or(&0));
        }
        ans
    }
}