impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut j = 1;
        let n = nums.len();
        while j < n {
            if nums[i] != nums[j] {
                nums[i+1] = nums[j];
                i += 1;
            }
            j += 1;
        }
        (i+1) as i32
    }
}