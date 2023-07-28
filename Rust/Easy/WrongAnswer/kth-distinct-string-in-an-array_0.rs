impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut set = std::collections::HashSet::new();
        for s in arr {
            set.insert(s);
        }
        let mut v = set.into_iter().collect::<Vec<String>>();
        v.sort();
        if v.len() < k as usize {
            return "".to_string();
        }
        v[k as usize - 1].to_string()
    }
}