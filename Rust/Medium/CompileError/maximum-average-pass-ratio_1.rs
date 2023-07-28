impl Solution {
    pub fn max_average_ratio(classes: Vec<Vec<i32>>, extra_students: i32) -> f64 {
        
        let mut classes = classes;
        let mut heap = std::collections::BinaryHeap::new();
        for c in classes.iter() {
            heap.push((c[0] as f64 / c[1] as f64, c[0], c[1]));
        }
        for _ in 0..extra_students {
            let (ratio, pass, total) = heap.pop().unwrap();
            heap.push(((pass as f64 + 1.0) / (total as f64 + 1.0), pass + 1, total + 1));
        }
        let mut sum = 0.0;
        for (_ratio, pass, total) in heap {
            sum += pass as f64 / total as f64;
        }
        sum / classes.len() as f64
    }
}