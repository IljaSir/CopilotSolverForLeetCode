impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut min = nums[0];
        for i in 0..nums.len() {
            if nums[i].abs() < min.abs() {
                min = nums[i];
            } else if nums[i].abs() == min.abs() && nums[i] > min {
                min = nums[i];
            }
        }
        return min;
    }
}