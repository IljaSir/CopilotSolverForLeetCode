impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut size = 1 << nums.len();
        for i in 0..size {
            let mut xor = 0;
            for j in 0..nums.len() {
                if i & (1 << j) != 0 {
                    xor ^= nums[j];
                }
            }
            res += xor;
        }
        res
    }
}