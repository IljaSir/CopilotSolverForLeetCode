impl Solution {
    pub fn xor_beauty(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                for k in 0..nums.len() {
                    ans ^= ((nums[i] | nums[j]) & nums[k]);
                }
            }
        }
        ans
    }
}