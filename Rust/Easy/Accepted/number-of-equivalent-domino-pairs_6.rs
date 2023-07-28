impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for domino in dominoes {
            let mut k = domino[0];
            let mut v = domino[1];
            if k > v {
                std::mem::swap(&mut k, &mut v);
            }
            let key = k * 10 + v;
            *map.entry(key).or_insert(0) += 1;
        }
        for (_, v) in map {
            count += v * (v - 1) / 2;
        }
        count
    }
}