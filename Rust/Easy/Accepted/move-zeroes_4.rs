impl Solution {
    pub fn move_zeroes(nums: &mut Vec<i32>) {
        
        let mut i = 0;
        let mut j = 0;
        while j < nums.len() {
            if nums[j] != 0 {
                nums.swap(i, j);
                i += 1;
            }
            j += 1;
        }
    }
}