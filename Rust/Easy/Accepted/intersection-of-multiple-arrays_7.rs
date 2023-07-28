impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut map = std::collections::HashMap::new();
        for i in nums.iter() {
            for j in i.iter() {
                let count = map.entry(j).or_insert(0);
                *count += 1;
            }
        }
        for (key, value) in map.iter() {
            if *value == nums.len() {
                result.push(**key);
            }
        }
        result.sort();
        result
    }
}