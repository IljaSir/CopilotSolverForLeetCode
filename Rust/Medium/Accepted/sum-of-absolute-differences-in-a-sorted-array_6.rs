impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![0; nums.len()];
        let mut sum = nums.iter().sum::<i32>();
        let mut pre = 0;
        for i in 0..nums.len() {
            ans[i] = (nums[i] * (i as i32) - pre) + (sum - pre - nums[i] * (nums.len() - i) as i32);
            pre += nums[i];
        }
        ans
    }
}