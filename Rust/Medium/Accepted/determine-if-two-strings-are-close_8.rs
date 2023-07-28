impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut h1 = std::collections::HashMap::new();
        let mut h2 = std::collections::HashMap::new();
        for ch in word1.chars() {
            *h1.entry(ch).or_insert(0) += 1;
        }
        for ch in word2.chars() {
            *h2.entry(ch).or_insert(0) += 1;
        }
        if h1.len() != h2.len() {
            return false;
        }
        let mut v1 = h1.values().collect::<Vec<_>>();
        let mut v2 = h2.values().collect::<Vec<_>>();
        v1.sort();
        v2.sort();
        if v1 != v2 {
            return false;
        }
        let mut v1 = h1.keys().collect::<Vec<_>>();
        let mut v2 = h2.keys().collect::<Vec<_>>();
        v1.sort();
        v2.sort();
        if v1 != v2 {
            return false;
        }
        true
    }
}