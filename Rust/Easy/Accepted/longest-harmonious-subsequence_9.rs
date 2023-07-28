impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut h = HashMap::new();
        for num in nums {
            *h.entry(num).or_insert(0) += 1;
        }
        let mut ans: i32 = 0;
        for (k, v) in h.iter() {
            if h.contains_key(&(k + 1)) {
                ans = ans.max(v + h[&(k + 1)]);
            }
        }
        ans
    }
}