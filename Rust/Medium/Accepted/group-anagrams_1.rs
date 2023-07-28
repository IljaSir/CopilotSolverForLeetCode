impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut map: std::collections::HashMap<String, Vec<String>> = std::collections::HashMap::new();
        for s in strs {
            let mut v: Vec<char> = s.chars().collect();
            v.sort();
            let k = v.into_iter().collect::<String>();
            if let Some(v) = map.get_mut(&k) {
                v.push(s);
            } else {
                map.insert(k, vec![s]);
            }
        }
        let mut result: Vec<Vec<String>> = Vec::new();
        for (_, v) in map {
            result.push(v);
        }
        result
    }
}