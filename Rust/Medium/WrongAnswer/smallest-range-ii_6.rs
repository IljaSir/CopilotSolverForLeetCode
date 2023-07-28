impl Solution {
    pub fn smallest_range_ii(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = nums[nums.len() - 1] - nums[0];
        for i in 0..nums.len() - 1 {
            let min = nums[i].min(nums[0] + 2 * k);
            let max = nums[nums.len() - 1].max(nums[i + 1] + 2 * k);
            ans = ans.min(max - min);
        }
        ans
    }
}