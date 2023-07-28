impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        let mut l = 1;
        let mut r = 10_000_000;
        while l < r {
            let mid = (l + r) >> 1;
            let mut h = 0.0;
            for i in 0..n-1 {
                h += (dist[i] + mid - 1) / mid;
            }
            h += dist[n-1] as f64 / mid as f64;
            if h <= hour {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if r == 10_000_000 {
            -1
        } else {
            r as i32
        }
    }
}