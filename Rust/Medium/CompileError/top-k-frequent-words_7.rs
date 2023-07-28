impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        let mut map: HashMap<&String, i32> = HashMap::new();
        for word in words {
            *map.entry(&word).or_insert(0) += 1;
        }
        let mut v: Vec<(&String, i32)> = map.into_iter().collect();
        v.sort_by(|a, b| match a.1.cmp(&b.1) {
            std::cmp::Ordering::Equal => b.0.cmp(a.0),
            x => x.reverse(),
        });
        v.into_iter().take(k as usize).map(|x| x.0.to_string()).collect()
    }
}