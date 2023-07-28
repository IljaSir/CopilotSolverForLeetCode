impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut order_map = std::collections::HashMap::new();
        for (i, ch) in order.chars().enumerate() {
            order_map.insert(ch, i);
        }
        for i in 1..words.len() {
            let mut j = 0;
            while j < words[i].len() && j < words[i - 1].len() {
                let c1 = words[i].chars().nth(j).unwrap();
                let c2 = words[i - 1].chars().nth(j).unwrap();
                if c1 != c2 {
                    if order_map[&c1] < order_map[&c2] {
                        return false;
                    }
                    break;
                }
                j += 1;
            }
            if j < words[i - 1].len() && j == words[i].len() {
                return false;
            }
        }
        true
    }
}