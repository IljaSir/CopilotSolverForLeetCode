impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut order_map = std::collections::HashMap::new();
        for (i, c) in order.chars().enumerate() {
            order_map.insert(c, i);
        }
        let mut s_chars: Vec<char> = s.chars().collect();
        s_chars.sort_by(|a, b| {
            match (order_map.get(a), order_map.get(b)) {
                (Some(a), Some(b)) => a.cmp(b),
                (Some(_), None) => std::cmp::Ordering::Less,
                (None, Some(_)) => std::cmp::Ordering::Greater,
                (None, None) => std::cmp::Ordering::Equal,
            }
        });
        s_chars.into_iter().collect()
    }
}