impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut max_sum = 0;
        while i < j {
            max_sum = max_sum.max(nums[i] + nums[j]);
            i += 1;
            j -= 1;
        }
        max_sum
    }
}