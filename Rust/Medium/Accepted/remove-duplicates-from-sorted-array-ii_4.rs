impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = 1;
        let mut count = 1;
        while j < nums.len() {
            if nums[i] == nums[j] {
                if count == 1 {
                    count += 1;
                    i += 1;
                    nums[i] = nums[j];
                }
            } else {
                count = 1;
                i += 1;
                nums[i] = nums[j];
            }
            j += 1;
        }
        i as i32 + 1
    }
}