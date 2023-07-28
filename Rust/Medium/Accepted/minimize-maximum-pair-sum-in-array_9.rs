impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut max = 0;
        for i in 0..nums.len()/2 {
            max = max.max(nums[i] + nums[nums.len()-1-i]);
        }
        max
    }
}