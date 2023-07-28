impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in nums {
            let count = map.entry(i).or_insert(0);
            *count += 1;
        }
        let mut max = 0;
        let mut result = 0;
        for (k, v) in map {
            if v > max {
                max = v;
                result = k;
            }
        }
        result
    }
}