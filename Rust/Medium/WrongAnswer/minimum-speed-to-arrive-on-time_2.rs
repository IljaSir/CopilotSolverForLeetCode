impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        if hour < (n - 1) as f64 {
            return -1;
        }
        let mut l = 1;
        let mut r = 1_000_000_000;
        while l < r {
            let mid = l + (r - l) / 2;
            let mut time = 0.0;
            for i in 0..n - 1 {
                time += (dist[i] as f64 / mid as f64).ceil();
            }
            time += (dist[n - 1] as f64 / mid as f64);
            if time <= hour {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l as i32
    }
}