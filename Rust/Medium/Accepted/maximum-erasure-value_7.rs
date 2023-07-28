impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut s = 0;
        let mut res = 0;
        let mut i = 0;
        let mut j = 0;
        let mut m = std::collections::HashMap::new();
        while j < nums.len() {
            if !m.contains_key(&nums[j]) {
                s += nums[j];
                m.insert(nums[j], j);
                j += 1;
                res = res.max(s);
            } else {
                s -= nums[i];
                m.remove(&nums[i]);
                i += 1;
            }
        }
        res
    }
}