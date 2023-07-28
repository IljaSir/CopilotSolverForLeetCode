impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        let mut map = std::collections::HashMap::new();
        for word in words {
            *map.entry(word).or_insert(0) += 1;
        }
        let mut vec: Vec<(&String, &i32)> = map.iter().collect();
        vec.sort_by(|(a, b), (c, d)| {
            if b == d {
                c.cmp(a)
            } else {
                d.cmp(b)
            }
        });
        vec.iter().map(|(a, _)| a.clone()).take(k as usize).collect()
    }
}