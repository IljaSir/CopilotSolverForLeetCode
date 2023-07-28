impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = nums[0];
        for i in 1..nums.len() {
            if (closest.abs() > nums[i].abs()) || (closest.abs() == nums[i].abs() && closest < nums[i]) {
                closest = nums[i];
            }
        }
        closest
    }
}