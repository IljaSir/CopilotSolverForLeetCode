impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        use std::collections::HashMap;
        let mut map: HashMap<char, i32> = HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut v = map.into_iter().collect::<Vec<_>>();
        v.sort_by(|a, b| b.1.cmp(&a.1));
        let mut res = String::new();
        for (c, n) in v {
            for _ in 0..n {
                res.push(c);
            }
        }
        res
    }
}