impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut pre = 0;
        let mut res = 0;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] {
                res += 1;
            } else {
                pre += 1;
                res = res.min(pre);
            }
        }
        res as i32
    }
}