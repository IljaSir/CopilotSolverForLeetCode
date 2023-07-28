impl Solution {
    pub fn max_average_ratio(classes: Vec<Vec<i32>>, extra_students: i32) -> f64 {
        
        let mut classes = classes;
        let mut pq = std::collections::BinaryHeap::new();
        for c in classes.iter() {
            pq.push((c[0] as f64 / c[1] as f64, c[0], c[1]));
        }
        for _ in 0..extra_students {
            let (ratio, passed, total) = pq.pop().unwrap();
            pq.push(((passed + 1.0) / (total + 1.0), passed + 1, total + 1));
        }
        let mut sum = 0.0;
        for (ratio, _, _) in pq.iter() {
            sum += ratio;
        }
        sum / classes.len() as f64
    }
}