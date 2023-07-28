impl Solution {
    pub fn destroy_targets(nums: Vec<i32>, space: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut j = 1;
        for i in 0..nums.len() {
            while j < nums.len() && nums[j] - nums[i] <= space {
                j += 1;
            }
            ans = ans.max(j - i);
        }
        nums[ans - 1]
    }
}