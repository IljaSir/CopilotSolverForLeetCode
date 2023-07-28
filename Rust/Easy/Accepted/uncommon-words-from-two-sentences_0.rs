impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for word in s1.split_whitespace() {
            *map.entry(word).or_insert(0) += 1;
        }
        for word in s2.split_whitespace() {
            *map.entry(word).or_insert(0) += 1;
        }
        map.into_iter()
            .filter(|&(_k, v)| v == 1)
            .map(|(k, _v)| k.to_string())
            .collect()
    }
}