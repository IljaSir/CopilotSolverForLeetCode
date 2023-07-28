impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut time: Vec<f64> = dist.iter().zip(speed.iter()).map(|(d, s)| *d as f64 / *s as f64).collect();
        time.sort_by(|a, b| a.partial_cmp(b).unwrap());
        let mut i = 0;
        while i < time.len() && time[i] > i as f64 {
            i += 1;
        }
        i as i32
    }
}