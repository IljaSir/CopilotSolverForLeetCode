impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut map2 = std::collections::HashMap::new();
        for (c1, c2) in s.chars().zip(t.chars()) {
            if let Some(&c) = map.get(&c1) {
                if c != c2 {
                    return false;
                }
            } else {
                map.insert(c1, c2);
            }
            if let Some(&c) = map2.get(&c2) {
                if c != c1 {
                    return false;
                }
            } else {
                map2.insert(c2, c1);
            }
        }
        true
    }
}