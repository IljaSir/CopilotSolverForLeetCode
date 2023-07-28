impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut map: std::collections::HashMap<String, usize> = std::collections::HashMap::new();
        let mut max = 0;
        let mut res = String::new();
        let mut s = String::new();
        for c in paragraph.chars() {
            if c.is_alphabetic() {
                s.push(c.to_ascii_lowercase());
            } else {
                if !s.is_empty() && !banned.contains(&s) {
                    *map.entry(s.clone()).or_insert(0) += 1;
                    if map[&s] > max {
                        max = map[&s];
                        res = s.clone();
                    }
                }
                s = String::new();
            }
        }
        if !s.is_empty() && !banned.contains(&s) {
            *map.entry(s.clone()).or_insert(0) += 1;
            if map[&s] > max {
                max = map[&s];
                res = s.clone();
            }
        }
        res
    }
}