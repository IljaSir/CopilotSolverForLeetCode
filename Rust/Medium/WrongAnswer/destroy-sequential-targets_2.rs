impl Solution {
    pub fn destroy_targets(nums: Vec<i32>, space: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 1;
        let mut max = 1;
        for i in 1..nums.len() {
            if nums[i] - nums[i - 1] <= space {
                res += 1;
            } else {
                res = 1;
            }
            max = max.max(res);
        }
        max
    }
}