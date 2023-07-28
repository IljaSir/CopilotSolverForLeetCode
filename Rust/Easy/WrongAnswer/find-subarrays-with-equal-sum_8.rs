impl Solution {
    pub fn find_subarrays(nums: Vec<i32>) -> bool {
        
        let mut s = 0;
        let mut h = std::collections::HashMap::new();
        for i in 0..nums.len() {
            s += nums[i];
            if h.contains_key(&s) {
                if i - h[&s] > 1 {
                    return true;
                }
            } else {
                h.insert(s, i);
            }
        }
        false
    }
}