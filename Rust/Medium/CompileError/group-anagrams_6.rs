impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        

        let mut result: Vec<Vec<String>> = Vec::new();
        let mut map: HashMap<String, usize> = HashMap::new();
        for str in strs {
            let mut chars: Vec<char> = str.chars().collect();
            chars.sort();
            let key = chars.into_iter().collect();
            if map.contains_key(&key) {
                result[map[&key]].push(str);
            } else {
                result.push(vec![str]);
                map.insert(key, result.len() - 1);
            }
        }
        result
    }
}