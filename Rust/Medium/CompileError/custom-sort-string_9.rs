impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut order = order.chars().collect::<Vec<char>>();
        let mut s = s.chars().collect::<Vec<char>>();
        let mut order_map = vec![0; 26];
        for i in 0..order.len() {
            order_map[order[i] as usize - 97] = i;
        }
        s.sort_by(|a, b| order_map[a as usize - 97].cmp(&order_map[b as usize - 97]));
        s.iter().collect::<String>()
    }
}