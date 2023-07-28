impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        use std::collections::HashMap;
        let mut map: HashMap<i32, i32> = HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut vec: Vec<(i32, i32)> = map.into_iter().collect();
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        vec.iter().take(k as usize).map(|(k, _)| *k).collect()
    }
}