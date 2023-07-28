impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        use std::collections::HashMap;
        let mut map: HashMap<String, i32> = HashMap::new();
        for w in words.into_iter() {
            *map.entry(w).or_insert(0) += 1;
        }
        let mut v: Vec<(&String, &i32)> = map.iter().collect();
        v.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(b.0)
            } else {
                b.1.cmp(a.1)
            }
        });
        v.into_iter().map(|x| x.0.to_string()).take(k as usize).collect()
    }
}