impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut order_map = std::collections::HashMap::new();
        let mut i = 0;
        for c in order.chars() {
            order_map.insert(c, i);
            i += 1;
        }
        let mut prev = &words[0];
        for w in words.iter().skip(1) {
            if !Self::is_sorted(prev, w, &order_map) {
                return false;
            }
            prev = w;
        }
        true
    }
    fn is_sorted(a: &str, b: &str, order_map: &std::collections::HashMap<char, usize>) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            let ca = a.chars().nth(i).unwrap();
            let cb = b.chars().nth(j).unwrap();
            if ca != cb {
                return order_map.get(&ca).unwrap() < order_map.get(&cb).unwrap();
            }
            i += 1;
            j += 1;
        }
        a.len() <= b.len()
    }
}