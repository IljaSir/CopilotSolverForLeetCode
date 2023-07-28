impl Solution {
    pub fn smallest_range_ii(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = nums.last().unwrap() - nums.first().unwrap();
        for i in 0..nums.len()-1 {
            let a = nums[i];
            let b = nums[i+1];
            let high = std::cmp::max(nums.last().unwrap() - k, a + k);
            let low = std::cmp::min(nums.first().unwrap() + k, b - k);
            res = std::cmp::min(res, high - low);
        }
        res
    }
}