impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut dist = dist;
        let mut speed = speed;
        let mut time = 0;
        let mut count = 0;
        while !dist.is_empty() {
            time += 1;
            for i in 0..dist.len() {
                dist[i] -= speed[i];
            }
            let mut idx = 0;
            while idx < dist.len() && dist[idx] <= 0 {
                idx += 1;
            }
            if idx > 0 {
                dist.drain(0..idx);
                speed.drain(0..idx);
                count += 1;
            }
            if count >= time {
                return time;
            }
        }
        count
    }
}