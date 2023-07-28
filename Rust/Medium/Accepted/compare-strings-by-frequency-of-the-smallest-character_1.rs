impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let queries: Vec<i32> = queries.iter().map(|q| Self::f(q)).collect();
        let words: Vec<i32> = words.iter().map(|w| Self::f(w)).collect();
        let mut res = vec![];
        for q in queries {
            let mut count = 0;
            for w in &words {
                if q < *w {
                    count += 1;
                }
            }
            res.push(count);
        }
        res
    }
    fn f(s: &str) -> i32 {
        let mut count = 0;
        let mut min = 'z';
        for c in s.chars() {
            if c < min {
                min = c;
                count = 1;
            } else if c == min {
                count += 1;
            }
        }
        count
    }
}