impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut map: HashMap<Vec<char>, Vec<String>> = HashMap::new();
        for s in strs {
            let mut key: Vec<char> = s.chars().collect();
            key.sort();
            match map.get_mut(&key) {
                Some(v) => v.push(s),
                None => { map.insert(key, vec![s]); },
            }
        }
        map.values().map(|v| v.clone()).collect()
    }
}