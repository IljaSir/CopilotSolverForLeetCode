impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut map = std::collections::HashMap::new();
        for s in arr {
            let count = map.entry(s).or_insert(0);
            *count += 1;
        }
        let mut v = map.into_iter().filter(|(_, count)| *count == 1).collect::<Vec<_>>();
        v.sort_by_key(|(s, _)| s.clone());
        if v.len() < k as usize {
            return "".to_string();
        }
        v[k as usize - 1].0
    }
}