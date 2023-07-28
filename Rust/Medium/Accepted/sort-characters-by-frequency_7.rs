impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut v = s.chars().collect::<Vec<char>>();
        v.sort_unstable_by(|a, b| b.cmp(a));
        let mut m = std::collections::HashMap::new();
        for c in v {
            *m.entry(c).or_insert(0) += 1;
        }
        let mut v = m.into_iter().collect::<Vec<(char, i32)>>();
        v.sort_unstable_by(|(_, a), (_, b)| b.cmp(a));
        let mut res = String::new();
        for (c, n) in v {
            for _ in 0..n {
                res.push(c);
            }
        }
        res
    }
}