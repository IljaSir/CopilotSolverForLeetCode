impl Solution {
    pub fn xor_game(nums: Vec<i32>) -> bool {
        
        let mut xor = 0;
        for num in nums {
            xor ^= num;
        }
        xor == 0 || nums.len() % 2 == 0
    }
}