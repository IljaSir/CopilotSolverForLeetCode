impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut count = 0;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] > nums[i + 1] {
                if i > 0 && nums[i - 1] > nums[i + 1] {
                    nums[i + 1] = nums[i];
                }
                count += 1;
            }
            i += 1;
        }
        count <= 1
    }
}