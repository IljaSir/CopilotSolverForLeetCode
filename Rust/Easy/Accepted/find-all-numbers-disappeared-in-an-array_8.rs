impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            let mut j = nums[i] as usize;
            if j != 0 && nums[j - 1] != 0 {
                nums[i] = nums[j - 1];
                nums[j - 1] = 0;
            } else {
                i += 1;
            }
        }
        nums.iter()
            .enumerate()
            .filter(|(_, &v)| v != 0)
            .map(|(i, _)| (i + 1) as i32)
            .collect()
    }
}