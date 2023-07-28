impl Solution {
    pub fn find_lonely(nums: Vec<i32>) -> Vec<i32> {
        
        let mut lonely = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            if i == 0 {
                if nums[i] != nums[i + 1] {
                    lonely.push(nums[i]);
                }
            } else if i == nums.len() - 1 {
                if nums[i] != nums[i - 1] {
                    lonely.push(nums[i]);
                }
            } else if nums[i] != nums[i - 1] && nums[i] != nums[i + 1] {
                lonely.push(nums[i]);
            }
            i += 1;
        }
        lonely
    }
}