impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = nums[0];
        for i in 1..nums.len() {
            let n = nums[i];
            if closest.abs() > n.abs() {
                closest = n;
            } else if closest.abs() == n.abs() {
                if closest < n {
                    closest = n;
                }
            }
        }
        closest
    }
}