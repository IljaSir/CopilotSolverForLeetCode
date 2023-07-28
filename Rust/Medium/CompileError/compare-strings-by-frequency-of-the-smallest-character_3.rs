impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut q = queries.into_iter().map(|s| Self::f(s)).collect::<Vec<i32>>();
        let mut w = words.into_iter().map(|s| Self::f(s)).collect::<Vec<i32>>();
        q.iter_mut().map(|i| {
            *i = w.iter().filter(|j| **j > *i).count() as i32;
            *i
        }).collect::<Vec<i32>>()
    }
    fn f(s: String) -> i32 {
        let mut c = [0; 26];
        for b in s.as_bytes() {
            c[(b - b'a') as usize] += 1;
        }
        c.iter().filter(|i| **i > 0).next().unwrap()
    }
}