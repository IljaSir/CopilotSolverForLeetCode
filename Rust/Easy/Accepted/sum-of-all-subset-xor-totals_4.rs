impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..(1 << nums.len()) {
            let mut tmp = 0;
            for j in 0..nums.len() {
                if (i >> j) & 1 == 1 {
                    tmp ^= nums[j];
                }
            }
            sum += tmp;
        }
        sum
    }
}