impl Solution {
    pub fn xor_game(nums: Vec<i32>) -> bool {
        
        let mut sum = 0;
        for n in nums.iter() {
            sum ^= n;
        }
        sum == 0 || nums.len() % 2 == 0
    }
}