impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut map: std::collections::HashMap<String, Vec<String>> = std::collections::HashMap::new();
        for s in strs {
            let mut chars: Vec<char> = s.chars().collect();
            chars.sort();
            let key = chars.into_iter().collect();
            map.entry(key).or_insert(vec![]).push(s);
        }
        map.into_iter().map(|(_, v)| v).collect()
    }
}