impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut map = std::collections::HashMap::new();
        for s in arr {
            let count = map.entry(s).or_insert(0);
            *count += 1;
        }
        let mut v = map.into_iter().filter(|(_, v)| *v == 1).collect::<Vec<_>>();
        v.sort_by(|a, b| a.0.cmp(&b.0));
        if v.len() < k as usize {
            return String::new();
        }
        v[k as usize - 1].0
    }
}