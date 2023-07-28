impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut order_map = std::collections::HashMap::new();
        for (i, c) in order.chars().enumerate() {
            order_map.insert(c, i);
        }
        let mut s: Vec<char> = s.chars().collect();
        s.sort_unstable_by_key(|c| order_map.get(c).unwrap_or(&26));
        s.into_iter().collect()
    }
}