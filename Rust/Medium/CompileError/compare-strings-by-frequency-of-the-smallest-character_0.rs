impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut q = Vec::new();
        let mut w = Vec::new();
        for s in queries {
            q.push(Self::f(&s));
        }
        for s in words {
            w.push(Self::f(&s));
        }
        w.sort();
        let mut res = Vec::new();
        for i in q {
            let mut cnt = 0;
            for j in &w {
                if i < *j {
                    cnt += 1;
                }
            }
            res.push(cnt as i32);
        }
        res
    }
    fn f(s: &str) -> i32 {
        let mut min = 'z' as i32 + 1;
        let mut cnt = 0;
        for c in s.chars() {
            if c as i32 < min {
                min = c as i32;
                cnt = 1;
            } else if c as i32 == min {
                cnt += 1;
            }
        }
        cnt
    }
}