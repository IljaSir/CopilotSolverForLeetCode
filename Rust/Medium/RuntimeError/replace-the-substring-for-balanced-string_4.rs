impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
        }
        let mut result = s.len();
        let mut start = 0;
        let mut end = 0;
        let n = s.len();
        while end < n {
            let c = s.chars().nth(end).unwrap();
            let count = map.entry(c).or_insert(0);
            *count -= 1;
            while map.values().all(|&x| x <= n as i32 / 4) {
                let c = s.chars().nth(start).unwrap();
                let count = map.entry(c).or_insert(0);
                *count += 1;
                result = result.min(end - start + 1);
                start += 1;
            }
            end += 1;
        }
        result as i32
    }
}