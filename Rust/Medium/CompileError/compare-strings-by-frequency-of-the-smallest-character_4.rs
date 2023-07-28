impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut words: Vec<i32> = words.iter().map(|s| Self::f(&s)).collect();
        words.sort();
        queries.iter().map(|s| {
            let f = Self::f(&s);
            words.iter().filter(|&&w| w > f).count() as i32
        }).collect()
    }
}