impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut max = 0;
        let mut prev = 0;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] || nums[i] == prev {
                continue;
            }
            if nums[i] == nums[i - 1] * nums[i - 1] {
                count += 1;
                max = max.max(count);
            } else {
                count = 0;
            }
            prev = nums[i];
        }
        if max == 0 {
            -1
        } else {
            max + 1
        }
    }
}