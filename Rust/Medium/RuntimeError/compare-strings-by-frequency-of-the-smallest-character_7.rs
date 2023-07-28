impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut word_count = vec![0; 11];
        for word in words {
            word_count[Self::f(word)] += 1;
        }
        for i in (1..word_count.len()).rev() {
            word_count[i-1] += word_count[i];
        }
        let mut result = Vec::new();
        for query in queries {
            result.push(word_count[Self::f(query)+1]);
        }
        result
    }
    fn f(s: String) -> usize {
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        for i in 0..count.len() {
            if count[i] > 0 {
                return count[i];
            }
        }
        0
    }
}