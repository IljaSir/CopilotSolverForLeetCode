impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        let mut res = 0;
        for domino in dominoes {
            let domino = if domino[0] < domino[1] {
                domino[0] * 10 + domino[1]
            } else {
                domino[1] * 10 + domino[0]
            };
            if let Some(cnt) = map.get_mut(&domino) {
                res += *cnt;
                *cnt += 1;
            } else {
                map.insert(domino, 1);
            }
        }
        res
    }
}