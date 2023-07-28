impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] != nums[i + 1] {
                return nums[i];
            }
            i += 2;
        }
        nums[nums.len() - 1]
    }
}