impl Solution {
    pub fn get_maximum_xor(nums: Vec<i32>, maximum_bit: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut xor = 0;
        for i in 0..nums.len() {
            xor ^= nums[i];
        }
        for i in 0..nums.len() {
            res.push(xor ^ (1 << maximum_bit) - 1);
            xor ^= nums[nums.len() - 1 - i];
        }
        res
    }
}