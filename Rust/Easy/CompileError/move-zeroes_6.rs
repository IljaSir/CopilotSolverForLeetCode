impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        
        let mut count = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == 0 {
                count += 1;
            } else {
                nums[i - count] = nums[i];
            }
            i += 1;
        }
        i = 0;
        while i < count {
            nums[nums.len() - 1 - i] = 0;
            i += 1;
        }
    }
}