impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut map2 = std::collections::HashMap::new();
        for (a, b) in s.chars().zip(t.chars()) {
            if let Some(v) = map.get(&a) {
                if *v != b {
                    return false;
                }
            } else {
                map.insert(a, b);
            }
            if let Some(v) = map2.get(&b) {
                if *v != a {
                    return false;
                }
            } else {
                map2.insert(b, a);
            }
        }
        true
    }
}