impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        use std::collections::HashMap;
        let mut h = HashMap::new();
        for c in s.chars() {
            let e = h.entry(c).or_insert(0);
            *e += 1;
        }
        let mut v = h.values().cloned().collect::<Vec<i32>>();
        v.sort();
        let mut r = 0;
        for i in 1..v.len() {
            if v[i] == v[i-1] {
                v[i] = 0;
                r += 1;
            } else if v[i] < v[i-1] {
                let d = v[i-1] - v[i];
                v[i] += d;
                r += d;
            }
        }
        r
    }
}