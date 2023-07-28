impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        let mut curr = 0;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] * nums[i - 1] {
                curr += 1;
            } else {
                curr = 0;
            }
            res = res.max(curr);
        }
        if res > 0 {
            res + 2
        } else {
            -1
        }
    }
}