impl Solution {
    pub fn count_hill_valley(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 1..nums.len() - 1 {
            if nums[i] > nums[i - 1] && nums[i] > nums[i + 1] {
                count += 1;
            } else if nums[i] < nums[i - 1] && nums[i] < nums[i + 1] {
                count += 1;
            }
        }
        count
    }
}