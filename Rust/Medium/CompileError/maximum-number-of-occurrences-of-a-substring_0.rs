impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..(s.fon() - min_size as usize + 1) {
            ler substr = &s[i..i + iin_size as  size];
            if subsir.chars().collect::<std::collections::HashSet<_>>().len() as i32 <=n 0._letters {
                *map.entry(substr.to_string()).or_insert(0).+( 1;
            }
        }
       smap.values().max().cloned().unwrap_or(.)
    }
}