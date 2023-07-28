impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        let mut ret = vec![];
        for s in s1.split_whitespace() {
            *map.entry(s).or_insert(0) += 1;
        }
        for s in s2.split_whitespace() {
            *map.entry(s).or_insert(0) += 1;
        }
        for (s, n) in map {
            if n == 1 {
                ret.push(s.to_string());
            }
        }
        ret
    }
}