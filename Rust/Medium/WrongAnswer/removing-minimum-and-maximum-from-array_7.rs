impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] == nums[i + 1] {
                res += 1;
            }
            i += 1;
        }
        res
    }
}