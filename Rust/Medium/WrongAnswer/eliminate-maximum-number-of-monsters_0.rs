impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut time = Vec::new();
        for i in 0..dist.len() {
            time.push(dist[i] as f64 / speed[i] as f64);
        }
        time.sort_by(|a, b| a.partial_cmp(b).unwrap());
        let mut cur = 0.0;
        for i in 0..time.len() {
            cur += 1.0;
            if time[i] < cur {
                return i as i32;
            }
        }
        time.len() as i32
    }
}