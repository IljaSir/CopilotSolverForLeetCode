impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut v = Vec::new();
        for c in s.chars() {
            if let Some(&c0) = v.last() {
                if c0.is_ascii_lowercase() {
                    if c0.to_ascii_uppercase() == c {
                        v.pop();
                        continue;
                    }
                } else {
                    if c0.to_ascii_lowercase() == c {
                        v.pop();
                        continue;
                    }
                }
            }
            v.push(c);
        }
        v.into_iter().collect()
    }
}