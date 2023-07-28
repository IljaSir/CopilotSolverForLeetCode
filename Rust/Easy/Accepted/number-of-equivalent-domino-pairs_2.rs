impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for domino in dominoes {
            let key = if domino[0] < domino[1] {
                (domino[0], domino[1])
            } else {
                (domino[1], domino[0])
            };
            *map.entry(key).or_insert(0) += 1;
        }
        for v in map.values() {
            count += v * (v - 1) / 2;
        }
        count
    }
}