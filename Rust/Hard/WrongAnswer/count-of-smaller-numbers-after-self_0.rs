impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; nums.len()];
        let mut sorted = vec![];
        for i in (0..nums.len()).rev() {
            let idx = sorted.binary_search(&nums[i]).unwrap_or_else(|x| x);
            sorted.insert(idx, nums[i]);
            res[i] = idx as i32;
        }
        res
    }
}