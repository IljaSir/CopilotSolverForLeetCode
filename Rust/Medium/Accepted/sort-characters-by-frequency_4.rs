impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut v: Vec<_> = map.into_iter().collect();
        v.sort_by(|a, b| b.1.cmp(&a.1));
        let mut res = String::new();
        for (c, n) in v {
            res.extend(std::iter::repeat(c).take(n));
        }
        res
    }
}