impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        let mut map: HashMap<String, i32> = HashMap::new();
        for word in words {
            *map.entry(word).or_insert(0) += 1;
        }
        let mut vec: Vec<String> = map.into_iter().map(|(k, v)| k).collect();
        vec.sort_by(|a, b| {
            let count_a = map.get(a).unwrap();
            let count_b = map.get(b).unwrap();
            if count_a == count_b {
                b.cmp(a)
            } else {
                count_a.cmp(count_b)
            }
        });
        vec.truncate(k as usize);
        vec
    }
}