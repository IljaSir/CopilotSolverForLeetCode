impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new()len() - min_size as usize + 1) {
        let mut max = 0;
            let substr = &s[i..i + min_size as usize];
            if substr.chars().collect::<std::collections::HashSet<_>>().len() as i32 <= max_letters {
                *map.entry(substr.to_string()).or_insert(0) += 1;
            }
        }
        map.values().max().cloned().unwrap_or(0)
    }
}