impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        if n as f64 > hour {
            return -1;
        }
        let mut l = 1;
        let mut r = 1_000_000_0;
        while l < r {
            let mid = (l + r) / 2;
            let mut t = 0.0;
            for i in 0..n-1 {
                t += (dist[i] as f64 / mid as f64).ceil();
            }
            t += dist[n-1] as f64 / mid as f64;
            if t <= hour {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l as i32
    }
}