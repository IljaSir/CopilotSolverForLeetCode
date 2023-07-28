impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for w in s1.split_whitespace() {
            *map.entry(w).or_insert(0) += 1;
        }
        for w in s2.split_whitespace() {
            *map.entry(w).or_insert(0) += 1;
        }
        map.iter().filter(|(_, v)| **v == 1).map(|(k, _)| k.to_string()).collect()
    }
}