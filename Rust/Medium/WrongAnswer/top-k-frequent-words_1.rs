impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for word in words {
            *map.entry(word).or_insert(0) += 1;
        }
        let mut vec = map.into_iter().collect::<Vec<_>>();
        vec.sort_by(|a, b| {
            a.1.cmp(&b.1).reverse().then_with(|| b.0.cmp(&a.0))
        });
        vec.into_iter().take(k as usize).map(|x| x.0).collect()
    }
}