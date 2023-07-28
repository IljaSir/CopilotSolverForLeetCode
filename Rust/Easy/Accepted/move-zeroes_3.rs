impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        
        let mut i = 0;
        let mut j = 0;
        while i < nums.len() {
            if nums[i] != 0 {
                nums[j] = nums[i];
                j += 1;
            }
            i += 1;
        }
        while j < nums.len() {
            nums[j] = 0;
            j += 1;
        }
    }
}