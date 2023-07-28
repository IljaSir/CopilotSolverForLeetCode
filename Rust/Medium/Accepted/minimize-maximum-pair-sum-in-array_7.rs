impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut max_sum = 0;
        while i < j {
            let sum = nums[i] + nums[j];
            max_sum = std::cmp::max(max_sum, sum);
            i += 1;
            j -= 1;
        }
        max_sum
    }
}