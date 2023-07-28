impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let l = s.len() / 4;
        let mut m = std::collections::HashMap::new();
        for c in s.chars() {
            *m.entry(c).or_insert(0) += 1;
        }
        let mut i = 0;
        let mut j = 0;
        let mut res = std::i32::MAX;
        while j < s.len() {
            if m.values().all(|&x| x <= l) {
                res = res.min((j - i) as i32);
                *m.entry(s.chars().nth(i).unwrap()).or_insert(0) += 1;
                i += 1;
            } else {
                *m.entry(s.chars().nth(j).unwrap()).or_insert(0) -= 1;
                j += 1;
            }
        }
        res
    }
}