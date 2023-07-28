impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut sorted = nums.clone();
        sorted.sort();
        let mut rotated = sorted.clone();
        for i in 1..sorted.len() {
            rotated.rotate_left(1);
            if nums == rotated {
                return true;
            }
        }
        nums == sorted
    }
}