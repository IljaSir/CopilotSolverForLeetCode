impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut counter = std::collections::HashMap::new();
        let mut max = 0;
        for i in 0..s.len() {
            if i + min_size as usize > s.len() {
                break;
            }
            let sub_str = &s[i..i + min_size as usize];
            if sub_str.chars().collect::<std::collections::HashSet<_>>().len() <= max_letters as usize {
                *counter.entry(sub_str).or_insert(0) += 1;
                if *counter.get(sub_str).unwrap() > max {
                    max = *counter.get(sub_str).unwrap();
                }
            }
        }
        max
    }
}