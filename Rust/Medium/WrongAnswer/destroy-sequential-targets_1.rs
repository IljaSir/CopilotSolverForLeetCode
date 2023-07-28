impl Solution {
    pub fn destroy_targets(nums: Vec<i32>, space: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 1;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] - nums[i] <= space {
                j += 1;
            }
            res = res.max(j - i);
            i = j;
        }
        nums[res - 1]
    }
}