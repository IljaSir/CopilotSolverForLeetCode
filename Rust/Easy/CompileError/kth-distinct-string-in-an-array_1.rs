impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut map = std::collections::HashMap::new();
        for s in arr {
            let c = map.entry(s).or_insert(0);
            *c += 1;
        }
        let mut v = map.into_iter().collect::<Vec<(String, i32)>>();
        v.sort_by(|a, b| a.1.cmp(&b.1));
        if v.len() < k as usize {
            return String::new();
        }
        v[k as usize - 1].0
    }
}