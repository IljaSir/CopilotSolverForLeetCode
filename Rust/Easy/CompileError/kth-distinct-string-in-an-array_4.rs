impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut map = std::collections::HashMap::new();
        for s in arr {
            *map.entry(s).or_insert(0) += 1;
        }
        let mut vec = map.into_iter().filter(|(_, v)| *v == 1).collect::<Vec<_>>();
        vec.sort_by_key(|(k, _)| k.clone());
        if vec.len() < k as usize {
            return "".to_string();
        }
        vec[k as usize - 1].0
    }
}