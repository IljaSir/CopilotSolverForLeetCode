impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let (mut i, mut j) = (0, nums.len() - 1);
        let mut max = 0;
        while i < j {
            max = max.max(nums[i] + nums[j]);
            i += 1;
            j -= 1;
        }
        max
    }
}