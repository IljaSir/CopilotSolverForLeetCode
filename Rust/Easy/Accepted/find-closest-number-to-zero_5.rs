impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = nums[0];
        for i in 1..nums.len() {
            let num = nums[i];
            if num == 0 {
                return 0;
            }
            if num.abs() < closest.abs() {
                closest = num;
            }
            if num.abs() == closest.abs() && num > closest {
                closest = num;
            }
        }
        closest
    }
}