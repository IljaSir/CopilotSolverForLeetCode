impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut sorted = nums.clone();
        sorted.sort();
        let mut rotated = nums.clone();
        let mut rotated2 = nums.clone();
        rotated.rotate_left(1);
        rotated2.rotate_right(1);
        rotated == sorted || rotated2 == sorted
    }
}