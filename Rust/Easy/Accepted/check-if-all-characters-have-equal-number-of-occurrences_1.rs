impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut iter = map.values();
        let mut first = iter.next().unwrap();
        for v in iter {
            if v != first {
                return false;
            }
        }
        true
    }
}