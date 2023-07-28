impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut map: std::collections::HashMap<char, u32> = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut it = map.values();
        let first = it.next();
        for v in it {
            if *v != *first.unwrap() {
                return false;
            }
        }
        true
    }
}