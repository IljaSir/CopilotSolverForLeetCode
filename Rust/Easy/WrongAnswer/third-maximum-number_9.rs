impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut i = nums.len() - 2;
        let mut cnt = 1;
        while i > 0 {
            if nums[i] != nums[i + 1] {
                cnt += 1;
                if cnt == 3 {
                    return nums[i];
                }
            }
            i -= 1;
        }
        nums[nums.len() - 1]
    }
}