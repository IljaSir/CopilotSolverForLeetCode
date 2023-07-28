impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = map.iter().collect::<Vec<_>>();
        v.sort_by(|a, b| a.1.cmp(&b.1));
        if k as usize > v.len() {
            return "".to_string();
        }
        v[k as usize - 1].0.to_string()
    }
}