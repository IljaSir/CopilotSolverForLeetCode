impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        if nums.len() <= 2 {
            return nums.len() as i32;
        }
        let mut i = 2;
        let mut j = 2;
        while j < nums.len() {
            if nums[i - 2] != nums[j] {
                nums[i] = nums[j];
                i += 1;
            }
            j += 1;
        }
        i as i32
    }
}