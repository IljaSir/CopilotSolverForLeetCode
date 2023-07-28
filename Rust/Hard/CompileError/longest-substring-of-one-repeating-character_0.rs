impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut s = s.as_bytes().to_vec();
        for i in 0..query_indices.len() {
            s[query_indices[i] as usize] = query_characters.as_bytes()[i];
            let mut count = 0;
            let mut max = 0;
            let mut prev = s[0];
            for c in s {
                if c == prev {
                    count += 1;
                    max = max.max(count);
                } else {
                    count = 1;
                    prev = c;
                }
            }
            result.push(max);
        }
        result
    }
}