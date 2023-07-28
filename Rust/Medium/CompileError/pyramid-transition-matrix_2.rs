impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for s in allowed {
            let (a, b, c) = (s.as_bytes()[0], s.as_bytes()[1], s.as_bytes()[2]);
            map.entry((a, b)).or_insert(Vec::new()).push(c);
        }
        let mut bottom = bottom.as_bytes().to_vec();
        let mut next = Vec::new();
        loop {
            next.clear();
            for i in 0..bottom.len() - 1 {
                let (a, b) = (bottom[i], bottom[i + 1]);
                if !map.contains_key(&(a, b)) {
                    return false;
                }
                if next.is_empty() {
                    next = map[&(a, b)].clone();
                } else {
                    let mut tmp = Vec::new();
                    for c in &next {
                        for d in &map[&(a, b)] {
                            tmp.push(vec![*c, *d]);
                        }
                    }
                    next = tmp.into_iter().flatten().collect();
                }
            }
            if next.len() == 1 {
                return true;
            }
            bottom = next;
        }
    }
}