impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut ret: Vec<String> = Vec::new();
        let mut map: std::collections::HashMap<&str, i32> = std::collections::HashMap::new();
        for word in s1.split(' ') {
            *map.entry(word).or_insert(0) += 1;
        }
        for word in s2.split(' ') {
            *map.entry(word).or_insert(0) += 1;
        }
        for (k, v) in map {
            if v == 1 {
                ret.push(k.to_string());
            }
        }
        ret
    }
}