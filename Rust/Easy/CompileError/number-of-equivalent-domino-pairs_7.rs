impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut count_map = std::collections::HashMap::new();
        for domino in dominoes {
            let mut key = domino[0] * 10 + domino[1];
            if domino[0] > domino[1] {
                key = domino[1] * 10 + domino[0];
            }
            let count = count_map.entry(key).or_insert(0);
            *count += 1;
        }
        for count in count_map.values() {
            count * (count - 1) / 2
        }
        count
    }
}