impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut max = 0;
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            max = max.max(nums[i] + nums[j]);
            i += 1;
            j -= 1;
        }
        max
    }
}