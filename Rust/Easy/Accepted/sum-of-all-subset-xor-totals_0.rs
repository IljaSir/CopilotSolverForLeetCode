impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..(1 << nums.len()) {
            let mut tmp = 0;
            for j in 0..nums.len() {
                if i & (1 << j) > 0 {
                    tmp ^= nums[j];
                }
            }
            res += tmp;
        }
        res
    }
}