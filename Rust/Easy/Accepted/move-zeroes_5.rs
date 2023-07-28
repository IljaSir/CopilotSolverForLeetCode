impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] != 0 {
                nums[count] = nums[i];
                count += 1;
            }
        }
        for i in count..nums.len() {
            nums[i] = 0;
        }
    }
}