impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut v = s.into_bytes();
        let mut m = std::collections::HashMap::new();
        for c in v.iter() {
            *m.entry(c).or_insert(0) += 1;
        }
        v.sort_by_key(|c| (m.get(c).unwrap(), c));
        v.reverse();
        String::from_utf8(v).unwrap()
    }
}