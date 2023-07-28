impl Solution {
    pub fn count_hill_valley(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut i = 1;
        while i < nums.len() - 1 {
            if nums[i - 1] < nums[i] && nums[i] > nums[i + 1] {
                count += 1;
            } else if nums[i - 1] > nums[i] && nums[i] < nums[i + 1] {
                count += 1;
            }
            i += 1;
        }
        count
    }
}