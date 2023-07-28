impl Solution {
    pub fn xor_game(nums: Vec<i32>) -> bool {
        
        if nums.len() % 2 == 0 {
            return true;
        }
        let mut xor = 0;
        for n in nums {
            xor ^= n;
        }
        xor == 0
    }
}