impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for c in s.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
        }
        let mut chars: Vec<char> = map.keys().cloned().collect();
        chars.sort_by(|a, b| map[b].cmp(&map[a]));
        let mut result = String::new();
        for c in chars {
            result.push_str(&c.to_string().repeat(map[&c]));
        }
        result
    }
}