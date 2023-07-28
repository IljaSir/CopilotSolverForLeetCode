impl Solution {
    pub fn xor_game(nums: Vec<i32>) -> bool {
        
        let mut xor = 0;
        for n in &nums {
            xor ^= n;
        }
        xor == 0 || nums.len() % 2 == 0
    }
}