impl Solution {
    pub fn kth_distinct(arr: Vec<String>, k: i32) -> String {
        
        let mut distinct = std::collections::HashSet::new();
        for s in arr {
            distinct.insert(s);
            if distinct.len() == k as usize {
                return distinct.iter().next().unwrap().clone();
            }
        }
        "".to_string()
    }
}