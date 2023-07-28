impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut words = s.split(' ');
        let mut map = std::collections::HashMap::new();
        let mut set = std::collections::HashSet::new();
        for (i, c) in pattern.chars().enumerate() {
            match words.next() {
                Some(w) => {
                    if let Some(&c2) = map.get(w) {
                        if c != c2 {
                            return false;
                        }
                    } else {
                        if set.contains(&c) {
                            return false;
                        }
                        map.insert(w, c);
                        set.insert(c);
                    }
                }
                None => return false,
            }
        }
        words.next().is_none()
    }
}