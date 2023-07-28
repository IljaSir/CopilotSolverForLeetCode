impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut map2 = std::collections::HashMap::new();
        let s: Vec<char> = s.chars().collect();
        let t: Vec<char> = t.chars().collect();
        for i in 0..s.len() {
            if !map.contains_key(&s[i]) {
                map.insert(s[i], t[i]);
            } else {
                if map.get(&s[i]) != Some(&t[i]) {
                    return false;
                }
            }
            if !map2.contains_key(&t[i]) {
                map2.insert(t[i], s[i]);
            } else {
                if map2.get(&t[i]) != Some(&s[i]) {
                    return false;
                }
            }
        }
        true
    }
}