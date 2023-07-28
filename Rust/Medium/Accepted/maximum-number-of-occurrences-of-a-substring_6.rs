impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut count = std::collections::HashMap::new();
        let mut max = 0;
        for i in 0..s.len() {
            let mut letters = std::collections::HashSet::new();
            let mut j = 0;
            while i + j < s.len() && j < max_size as usize {
                letters.insert(s.as_bytes()[i + j]);
                j += 1;
                if j >= min_size as usize && letters.len() <= max_letters as usize {
                    let n = count.entry(s[i..i + j].to_string()).or_insert(0);
                    *n += 1;
                    max = std::cmp::max(max, *n);
                }
            }
        }
        max
    }
}