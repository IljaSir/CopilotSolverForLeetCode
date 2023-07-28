impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for s in allowed {
            map.entry(s[0..2].to_string()).or_insert(Vec::new()).push(s[2..3].to_string());
        }
        let mut stack = Vec::new();
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut s = bottom;
        while !s.is_empty() {
            if i == s.len() - 1 {
                i = 0;
                j += 1;
                k = 0;
                s = stack.pop().unwrap();
                continue;
            }
            let key = s[i..i+2].to_string();
            if map.contains_key(&key) {
                let mut new_s = s.clone();
                new_s.replace_range(i..i+2, &map[&key][k]);
                if j == 0 {
                    if new_s.len() == 1 {
                        return true;
                    }
                    i = 0;
                    j = 0;
                    k = 0;
                    s = new_s;
                    continue;
                }
                stack.push(new_s);
            }
            k += 1;
            if k == map[&key].len() {
                k = 0;
                i += 1;
            }
        }
        false
    }
}