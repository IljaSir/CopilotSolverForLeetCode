impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        

        if nums.len() < 3 {
            return nums.len() as i32;
        }
        let mut i = 2;
        for j in 2..nums.len() {
            if nums[i-2] != nums[j] {
                nums[i] = nums[j];
                i += 1;
            }
        }
        i as i32
    }
}