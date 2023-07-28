impl Solution {
    pub fn max_sum_min_product(nums: Vec<i32>) -> i32 {
        
        let len = nums.len();
        let mut stack = vec![];
        let mut left = vec![0; len];
        let mut right = vec![len; len];
        for i in 0..len {
            while let Some(&j) = stack.last() {
                if nums[j] < nums[i] {
                    break;
                }
                right[j] = i;
                stack.pop();
            }
            left[i] = if let Some(&j) = stack.last() {
                j + 1
            } else {
                0
            };
            stack.push(i);
        }
        let mut sum = vec![0; len + 1];
        for i in 0..len {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut ans = 0;
        for i in 0..len {
            ans = ans.max(nums[i] as i64 * (sum[right[i]] - sum[left[i]]) as i64);
        }
        (ans % 1_000_000_007) as i32
    }
}