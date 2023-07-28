impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while j < nums.len() {
            if j == 0 || nums[j] != nums[j - 1] {
                count = 1;
            } else {
                count += 1;
            }
            if count <= 2 {
                nums[i] = nums[j];
                i += 1;
            }
            j += 1;
        }
        i as i32
    }
}