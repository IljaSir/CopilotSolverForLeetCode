impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut prefix = vec![0; nums.len() + 1];
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            prefix[sum as usize] += 1;
        }
        let mut ret = 0;
        for i in 0..=nums.len() {
            ret += prefix[i] * prefix[i + goal as usize];
        }
        ret as i32
    }
}