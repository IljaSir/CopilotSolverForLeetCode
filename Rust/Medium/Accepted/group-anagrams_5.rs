impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut result: Vec<Vec<String>> = Vec::new();
        let mut map: std::collections::HashMap<String, Vec<String>> = std::collections::HashMap::new();
        for s in strs {
            let mut key: Vec<char> = s.chars().collect();
            key.sort();
            let key = key.into_iter().collect();
            if let Some(v) = map.get_mut(&key) {
                v.push(s);
            } else {
                map.insert(key, vec![s]);
            }
        }
        for (_, v) in map {
            result.push(v);
        }
        result
    }
}