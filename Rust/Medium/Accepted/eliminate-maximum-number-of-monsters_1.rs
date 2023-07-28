impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let n = dist.len();
        let mut times = Vec::new();
        for i in 0..n {
            times.push((dist[i] + speed[i] - 1) / speed[i]);
        }
        times.sort();
        let mut t = 0;
        for i in 0..n {
            if times[i] <= t {
                return i as i32;
            }
            t += 1;
        }
        n as i32
    }
}