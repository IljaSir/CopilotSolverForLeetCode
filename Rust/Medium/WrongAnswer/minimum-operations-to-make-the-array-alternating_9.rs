impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut ans = (0, 0);
        for i in 0..nums.len() {
            if i % 2 == 0 {
                ans.0 += (nums[i] - 1) / 2;
                ans.1 += nums[i] / 2;
            } else {
                ans.0 += nums[i] / 2;
                ans.1 += (nums[i] - 1) / 2;
            }
        }
        ans.0.min(ans.1) as i32
    }
}