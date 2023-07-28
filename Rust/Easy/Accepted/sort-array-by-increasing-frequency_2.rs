impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut vec = map.into_iter().collect::<Vec<(i32, i32)>>();
        vec.sort_by(|a, b| a.1.cmp(&b.1).then(b.0.cmp(&a.0)));
        vec.into_iter().flat_map(|(k, v)| vec![k; v as usize]).collect()
    }
}