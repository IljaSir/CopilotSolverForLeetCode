impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for &i in nums.iter() {
            *map.entry(i).or_insert(0) += 1;
        }
        map.into_iter().max_by_key(|&(_, v)| v).unwrap().0
    }
}