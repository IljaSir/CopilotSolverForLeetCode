impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let s = s.as_bytes();
        let query_characters = query_characters.as_bytes();
        let mut result = Vec::new();
        for (i, &ch) in query_characters.iter().enumerate() {
            let mut count = 0;
            let mut max = 0;
            for j in 0..s.len() {
                if s[j] == ch {
                    count += 1;
                    max = std::cmp::max(max, count);
                } else {
                    count = 0;
                }
                if j == query_indices[i] as usize {
                    result.push(max);
                }
            }
        }
        result
    }
}