impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut t = vec![];
        for i in 0..dist.len() {
            t.push((dist[i] as f64 / speed[i] as f64).ceil() as i32);
        }
        t.sort_unstable();
        let mut i = 0;
        while i < t.len() && t[i] > i as i32 {
            i += 1;
        }
        i as i32
    }
}