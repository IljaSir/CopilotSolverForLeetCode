impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for c in s.chars() {
            let counter = map.entry(c).or_insert(0);
            *counter += 1;
        }
        let mut vec = map.into_iter().collect::<Vec<_>>();
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        let mut result = String::new();
        for (c, n) in vec {
            for _ in 0..n {
                result.push(c);
            }
        }
        result
    }
}