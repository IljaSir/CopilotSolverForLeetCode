impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut map = std::collections::HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut result = Vec::new();
        for (k, v) in map {
            if v > nums.len() / 3 {
                result.push(k);
            }
        }
        result
    }
}