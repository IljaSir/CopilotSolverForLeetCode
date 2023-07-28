impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = nums[0];
        let mut min = nums[0].abs();
        for num in nums {
            if num.abs() < min {
                closest = num;
                min = num.abs();
            } else if num.abs() == min && num > closest {
                closest = num;
            }
        }
        closest
    }
}