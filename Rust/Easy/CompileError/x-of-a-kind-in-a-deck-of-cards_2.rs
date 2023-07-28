impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in deck {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = map.values().collect::<Vec<_>>();
        v.sort();
        for i in 2..=v[0] {
            if v.iter().all(|x| x % i == 0) {
                return true;
            }
        }
        false
    }
}