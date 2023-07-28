impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut sorted = nums.clone();
        sorted.sort();
        let mut rotated = nums.clone();
        rotated.rotate_right(1);
        nums == sorted || nums == rotated
    }
}