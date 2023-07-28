impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut map = std::collections::HashMap::new();
        for s in strs {
            let mut v = s.chars().collect::<Vec<char>>();
            v.sort();
            let key = v.into_iter().collect::<String>();
            map.entry(key).or_insert(Vec::new()).push(s);
        }
        map.values().map(|v| v.clone()).collect()
    }
}