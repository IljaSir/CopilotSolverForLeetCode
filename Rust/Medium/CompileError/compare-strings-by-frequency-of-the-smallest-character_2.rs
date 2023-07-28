impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut q = Vec::new();
        let mut w = Vec::new();
        for i in queries {
            q.push(frequency(i));
        }
        for i in words {
            w.push(frequency(i));
        }
        let mut result = Vec::new();
        for i in q {
            let mut count = 0;
            for j in &w {
                if i < *j {
                    count += 1;
                }
            }
            result.push(count);
        }
        result
    }
}