impl Solution {
    pub fn maximum_xor(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in (0..nums.len()).rev() {
            let mut j = i + 1;
            while j < nums.len() {
                ans = ans.max(nums[i] ^ nums[j]);
                j += 1;
            }
        }
        ans
    }
}