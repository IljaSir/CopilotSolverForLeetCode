impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut res = 0;
        let mut streak = 0;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] * nums[i - 1] {
                streak += 1;
            } else {
                res = res.max(streak);
                streak = 0;
            }
        }
        res.max(streak) + 1
    }
}