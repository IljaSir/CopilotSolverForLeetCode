impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut max = 0;
        let mut count = 1;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] {
                continue;
            }
            if nums[i] == nums[i - 1] * nums[i - 1] {
                count += 1;
                max = std::cmp::max(count, max);
            } else {
                count = 1;
            }
        }
        if max < 2 {
            -1
        } else {
            max as i32
        }
    }
}