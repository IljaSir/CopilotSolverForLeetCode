impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let (mut l, mut r) = (1, 10_000_001);
        while l < r {
            let m = (l + r) >> 1;
            let mut t = 0.0;
            for i in 0..dist.len() - 1 {
                t += (dist[i] as f64 / m as f64).ceil();
            }
            t += dist[dist.len() - 1] as f64 / m as f64;
            if t <= hour {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if l < 10_000_001 {
            l as i32
        } else {
            -1
        }
    }
}