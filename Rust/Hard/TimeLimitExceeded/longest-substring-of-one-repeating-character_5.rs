impl Solution {
    pub fn longest_repeating(s: String, query_characters: String, query_indices: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut s = s.into_bytes();
        for (q, i) in query_characters.into_bytes().iter().zip(query_indices) {
            s[i as usize] = *q;
            let mut count = 1;
            let mut max_count = 1;
            for j in 1..s.len() {
                if s[j] == s[j - 1] {
                    count += 1;
                    if count > max_count {
                        max_count = count;
                    }
                } else {
                    count = 1;
                }
            }
            result.push(max_count);
        }
        result
    }
}