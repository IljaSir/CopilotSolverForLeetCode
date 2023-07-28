impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut q = vec![];
        let mut w = vec![];
        for i in 0..queries.len() {
            q.push(Self::f(&queries[i]));
        }
        for i in 0..words.len() {
            w.push(Self::f(&words[i]));
        }
        for i in 0..q.len() {
            let mut count = 0;
            for j in 0..w.len() {
                if q[i] < w[j] {
                    count += 1;
                }
            }
            res.push(count);
        }
        res
    }
    fn f(s: &str) -> i32 {
        let mut count = 1;
        let mut min = s.chars().nth(0).unwrap();
        for i in 1..s.len() {
            let c = s.chars().nth(i).unwrap();
            if c == min {
                count += 1;
            } else if c < min {
                min = c;
                count = 1;
            }
        }
        count
    }
}