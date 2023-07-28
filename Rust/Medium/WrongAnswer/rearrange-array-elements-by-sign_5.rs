impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        let mut j = 1;
        while j < nums.len() {
            if nums[i] < 0 && nums[j] > 0 {
                i += 2;
                j += 2;
            } else if nums[i] > 0 && nums[j] < 0 {
                i += 2;
                j += 2;
            } else if nums[i] < 0 && nums[j] < 0 {
                j += 1;
            } else if nums[i] > 0 && nums[j] > 0 {
                j += 1;
            } else {
                nums.swap(i + 1, j);
                i += 2;
                j += 2;
            }
        }
        nums
    }
}