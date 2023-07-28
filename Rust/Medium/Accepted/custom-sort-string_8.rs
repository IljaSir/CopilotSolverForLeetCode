impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut order = order.chars().collect::<Vec<char>>();
        s.sort_by_key(|&c| order.iter().position(|&x| x == c).unwrap_or(27));
        s.iter().collect()
    }
}