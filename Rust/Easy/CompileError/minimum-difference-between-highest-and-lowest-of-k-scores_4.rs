impl Solution {
    pub fn minimum_difference(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let k = k as usize;
        let mut res = std::i32::MAX;
        for i in 0..nums.len()-k+1 {
            res = res.min(nums[i+k-1] - nums[i]);
        }
        res
    }
}