impl Solution {
    pub fn find_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == (i as i32) + 1 {
                i += 1;
                continue;
            }
            if nums[i] == nums[nums[i] as usize - 1] {
                return nums[i];
            }
            nums.swap(i, nums[i] as usize - 1);
        }
        0
    }
}