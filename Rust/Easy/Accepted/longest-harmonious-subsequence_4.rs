impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut hm: HashMap<i32, i32> = HashMap::new();
        for n in nums.iter() {
            *hm.entry(*n).or_insert(0) += 1;
        }
        let mut max = 0;
        for (k, v) in hm.iter() {
            if hm.contains_key(&(k + 1)) {
                max = max.max(v + hm.get(&(k + 1)).unwrap());
            }
        }
        max
    }
}