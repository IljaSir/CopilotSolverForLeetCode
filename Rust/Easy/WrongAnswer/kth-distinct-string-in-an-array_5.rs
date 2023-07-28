impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut count = std::collections::HashMap::new();
        for s in arr {
            let c = count.entry(s).or_insert(0);
            *c += 1;
        }
        let mut count = count.into_iter().collect::<Vec<_>>();
        count.sort_by(|a, b| a.0.cmp(&b.0));
        count.sort_by(|a, b| b.1.cmp(&a.1));
        if count.len() < k as usize {
            return "".to_string();
        }
        count[k as usize - 1].0.to_string()
    }
}