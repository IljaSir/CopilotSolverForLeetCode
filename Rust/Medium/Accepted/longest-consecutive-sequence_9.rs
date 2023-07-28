impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort_unstable();
        let mut max = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if i > 0 && nums[i] == nums[i - 1] + 1 {
                count += 1;
            } else if i > 0 && nums[i] == nums[i - 1] {
                continue;
            } else {
                count = 1;
            }
            max = max.max(count);
        }
        max
    }
}