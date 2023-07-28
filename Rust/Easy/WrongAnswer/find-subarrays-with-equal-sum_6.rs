impl Solution {
    pub fn find_subarrays(nums: Vec<i32>) -> bool {
        
        let mut s = 0;
        let mut m = std::collections::HashMap::new();
        for i in 0..nums.len() {
            s += nums[i];
            if m.contains_key(&s) {
                if i - m[&s] >= 2 {
                    return true;
                }
            } else {
                m.insert(s, i);
            }
        }
        false
    }
}