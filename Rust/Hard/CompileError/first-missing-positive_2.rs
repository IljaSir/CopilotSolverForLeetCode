impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let len = nums.len() as i32;
        for i in 0..nums.len() {
            while nums[i] > 0 && nums[i] <= len && nums[nums[i] as usize - 1] != nums[i] {
                nums.swap(i, nums[i] as usize - 1);
            }
        }
        for i in 0..nums.len() {
            if nums[i] != i as i32 + 1 {
                return i as i32 + 1;
            }
        }
        len + 1
    }
}