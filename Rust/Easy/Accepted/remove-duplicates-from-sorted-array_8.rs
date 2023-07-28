impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut j = 1;
        let mut k = 1;
        while j < nums.len() {
            if nums[i] == nums[j] {
                j += 1;
            } else {
                nums[k] = nums[j];
                k += 1;
                i = j;
                j += 1;
            }
        }
        k as i32
    }
}