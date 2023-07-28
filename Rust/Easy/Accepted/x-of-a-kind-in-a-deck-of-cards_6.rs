impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in deck {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut v = map.values().map(|x| *x).collect::<Vec<_>>();
        v.sort();
        let mut i = 2;
        while i <= v[0] {
            let mut j = 0;
            while j < v.len() {
                if v[j] % i != 0 {
                    break;
                }
                j += 1;
            }
            if j == v.len() {
                return true;
            }
            i += 1;
        }
        false
    }
}