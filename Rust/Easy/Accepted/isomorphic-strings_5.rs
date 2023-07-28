impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut used = std::collections::HashSet::new();
        for (c1, c2) in s.chars().zip(t.chars()) {
            match map.get(&c1) {
                Some(&c2_) => {
                    if c2 != c2_ {
                        return false;
                    }
                }
                None => {
                    if used.contains(&c2) {
                        return false;
                    }
                    map.insert(c1, c2);
                    used.insert(c2);
                }
            }
        }
        true
    }
}