impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut time = Vec::new();
        for i in 0..dist.len() {
            time.push((dist[i] + speed[i] - 1) / speed[i]);
        }
        time.sort();
        let mut t = 0;
        let mut i = 0;
        while i < time.len() && time[i] > t {
            i += 1;
            t += 1;
        }
        i as i32
    }
}