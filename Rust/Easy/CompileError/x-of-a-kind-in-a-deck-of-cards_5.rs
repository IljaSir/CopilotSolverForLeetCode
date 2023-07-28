impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for n in deck {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut gcd = 0;
        for v in map.values() {
            gcd = gcd::gcd(gcd, *v);
        }
        gcd >= 2
    }
}