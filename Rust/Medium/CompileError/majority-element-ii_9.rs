impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        let mut ret = Vec::new();
        for num in nums {
            let entry = map.entry(num).or_insert(0);
            *entry += 1;
        }
        let n = nums.len();
        for (k, v) in map {
            if v > n/3 {
                ret.push(k);
            }
        }
        ret
    }
}