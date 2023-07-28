impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut streak = 0;
        let mut longest_streak = 0;
        for i in 2..nums.len() {
            if nums[i] == nums[i-1] * nums[i-1] {
                streak += 1;
                longest_streak = longest_streak.max(streak);
            } else {
                streak = 0;
            }
        }
        if longest_streak > 0 {
            longest_streak + 2
        } else {
            -1
        }
    }
}