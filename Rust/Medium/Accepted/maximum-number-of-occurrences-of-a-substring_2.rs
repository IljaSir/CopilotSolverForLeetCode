impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for i in 0..s.len() - min_size as usize + 1 {
            let substr = &s[i..i + min_size as usize];
            if substr.chars().collect::<std::collections::HashSet<_>>().len() <= max_letters as usize {
                let count = map.entry(substr).or_insert(0);
                *count += 1;
                if *count > max {
                    max = *count;
                }
            }
        }
        max
    }
}