impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut max = 0;
        let mut cur = 1;
        for i in 1..nums.len() {
            if nums[i] == nums[i - 1] {
                continue;
            }
            if nums[i] == nums[i - 1] + 1 {
                cur += 1;
            } else {
                max = max.max(cur);
                cur = 1;
            }
        }
        max.max(cur)
    }
}