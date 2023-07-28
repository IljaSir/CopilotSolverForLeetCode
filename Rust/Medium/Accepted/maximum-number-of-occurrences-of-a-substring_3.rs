impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..s.len() {
            let mut set = std::collections::HashSet::new();
            for j in i..std::cmp::min(i + max_size as usize, s.len()) {
                set.insert(s.as_bytes()[j]);
                if set.len() > max_letters as usize {
                    break;
                }
                if j - i + 1 >= min_size as usize {
                    *map.entry(&s[i..j + 1]).or_insert(0) += 1;
                }
            }
        }
        map.values().max().unwrap_or(&0).clone()
    }
}