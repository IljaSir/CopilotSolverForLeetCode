impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        if (n as f64) > hour {
            return -1;
        }

        let mut left = 1;
        let mut right = 1_000_000_000;
        while left < right {
            let mid = left + (right - left) / 2;
            let mut time = 0.0;
            for i in 0..n - 1 {
                time += (dist[i] as f64) / (mid as f64);
                if time.ceil() > hour {
                    break;
                }
            }
            time += (dist[n - 1] as f64) / (mid as f64);
            if time > hour {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}