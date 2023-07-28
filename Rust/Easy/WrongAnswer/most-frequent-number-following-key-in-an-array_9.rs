impl Solution {
    pub fn most_frequent(nums: Vec<i32>, key: i32) -> i32 {
        
        let mut counts = std::collections::HashMap::new();
        let mut last_key = None;
        for i in 0..nums.len() {
            if last_key == Some(key) && nums[i] != key {
                *counts.entry(nums[i]).or_insert(0) += 1;
            }
            if nums[i] == key {
                last_key = Some(key);
            } else {
                last_key = None;
            }
        }
        let mut max = (0, 0);
        for (k, v) in counts {
            if v > max.1 {
                max = (k, v);
            }
        }
        max.0
    }
}