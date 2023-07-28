impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut map = std::collections::HashMap::new();
        for s in arr {
            map.entry(s).and_modify(|v| *v += 1).or_insert(1);
        }
        let mut v = map.iter().filter(|(_, &v)| v == 1).collect::<Vec<_>>();
        v.sort_by(|a, b| a.0.cmp(b.0));
        if v.len() < k as usize {
            return "".to_string();
        }
        v[k as usize - 1].0.to_string()
    }
}