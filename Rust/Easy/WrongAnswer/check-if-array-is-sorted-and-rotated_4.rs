impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut sorted_nums = nums.clone();
        sorted_nums.sort();
        for i in 1..nums.len() {
            let mut rotated_nums = nums.clone();
            rotated_nums.rotate_left(i);
            if rotated_nums == sorted_nums {
                return true;
            }
        }
        false
    }
}