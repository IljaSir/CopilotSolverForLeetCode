impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut freq = vec![0; 11];
        for word in words {
            let f = Self::f(word);
            freq[f] += 1;
        }
        for i in (1..11).rev() {
            freq[i-1] += freq[i];
        }
        queries
            .iter()
            .map(|q| freq[Self::f(q.clone()) + 1])
            .collect()
    }
}