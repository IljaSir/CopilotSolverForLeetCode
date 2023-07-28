impl Solution {
    pub fn xor_game(nums: Vec<i32>) -> bool {
        
        nums.len() % 2 == 0 || nums.iter().fold(0, |a, b| a ^ b) == 0
    }
}