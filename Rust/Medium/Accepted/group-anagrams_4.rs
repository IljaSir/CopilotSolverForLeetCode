impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut map = std::collections::HashMap::new();
        for s in strs {
            let mut key = vec![0; 26];
            for c in s.chars() {
                key[(c as usize) - 97] += 1;
            }
            map.entry(key).or_insert(Vec::new()).push(s);
        }
        map.values().map(|v| v.clone()).collect()
    }
}