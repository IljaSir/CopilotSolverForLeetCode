impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut vec = map.into_iter().collect::<Vec<_>>();
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        vec.into_iter().map(|(c, n)| c.to_string().repeat(n)).collect()
    }
}