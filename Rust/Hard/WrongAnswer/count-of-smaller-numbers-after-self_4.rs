impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut res = vec![0; nums.len()];
        let mut sorted = Vec::new();
        for i in (0..nums.len()).rev() {
            let idx = match sorted.binary_search(&nums[i]) {
                Ok(idx) => idx,
                Err(idx) => idx,
            };
            res[i] = idx as i32;
            sorted.insert(idx, nums[i]);
        }
        res
    }
}