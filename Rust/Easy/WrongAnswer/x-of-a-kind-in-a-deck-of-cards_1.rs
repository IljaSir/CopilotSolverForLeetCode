impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for i in deck {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = map.values().collect::<Vec<&i32>>();
        v.sort();
        let mut i = 0;
        let mut j = 1;
        while j < v.len() {
            if v[i] != v[j] {
                return false;
            }
            i += 1;
            j += 1;
        }
        true
    }
}