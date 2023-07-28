impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        use std::collections::HashMap;
        let mut map: HashMap<&str, i32> = HashMap::new();
        for word in words {
            *map.entry(word.as_str()).or_insert(0) += 1;
        }
        let mut map: Vec<(&str, i32)> = map.into_iter().collect();
        map.sort_by(|a, b| {
            if a.1 == b.1 {
                b.0.cmp(a.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        map.into_iter().rev().take(k as usize).map(|x| x.0.to_string()).collect()
    }
}