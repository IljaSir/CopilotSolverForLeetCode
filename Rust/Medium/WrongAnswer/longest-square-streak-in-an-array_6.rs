impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut streak = 0;
        let mut i = 1;
        while i < nums.len() {
            if nums[i] == nums[i - 1] * nums[i - 1] {
                let mut j = i;
                while j < nums.len() && nums[j] == nums[j - 1] * nums[j - 1] {
                    j += 1;
                }
                streak = streak.max(j - i + 1);
                i = j;
            } else {
                i += 1;
            }
        }
        if streak < 2 {
            -1
        } else {
            streak as i32
        }
    }
}