impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut t = dist
            .into_iter()
            .zip(speed)
            .map(|(d, s)| (d as f64 / s as f64).ceil() as i32)
            .collect::<Vec<_>>();
        t.sort();
        let mut i = 0;
        while i < t.len() && i as i32 < t[i] {
            i += 1;
        }
        i as i32
    }
}