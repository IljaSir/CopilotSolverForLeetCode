impl Solution {
    pub fn max_average_ratio(classes: Vec<Vec<i32>>, extra_students: i32) -> f64 {
        
        let mut classes = classes;
        let mut res = 0.0;
        let mut pq = std::collections::BinaryHeap::new();
        for c in classes {
            let p = c[0] as f64;
            let t = c[1] as f64;
            let r = (p + 1.0) / (t + 1.0) - p / t;
            pq.push((r, p, t));
        }
        for _ in 0..extra_students {
            let (r, p, t) = pq.pop().unwrap();
            res += p / t;
            pq.push((r, p + 1.0, t + 1.0));
        }
        while let Some((_, p, t)) = pq.pop() {
            res += p / t;
        }
        res / classes.len() as f64
    }
}