impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut count = 0;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] > nums[i + 1] {
                count += 1;
                if count > 1 {
                    return false;
                }
                if i > 0 && nums[i - 1] > nums[i + 1] {
                    nums[i + 1] = nums[i];
                }
            }
            i += 1;
        }
        true
    }
}