impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while j < nums.len() {
            if nums[j] == nums[i] {
                if count < 2 {
                    count += 1;
                    nums[i + 1] = nums[j];
                    i += 1;
                }
            } else {
                count = 1;
                nums[i + 1] = nums[j];
                i += 1;
            }
            j += 1;
        }
        i as i32
    }
}