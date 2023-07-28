impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut is_sorted = true;
        let mut is_rotated = false;
        for i in 0..nums.len() {
            if nums[i] > nums[(i+1) % nums.len()] {
                is_sorted = false;
                if is_rotated {
                    return false
                }
                is_rotated = true;
            }
        }
        is_sorted || is_rotated
    }
}