impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        let mut left = 1;
        let mut right = 10000000;
        while left < right {
            let mid = left + (right - left) / 2;
            let mut time = 0.0;
            for i in 0..n {
                time += if i == n - 1 { dist[i] as f64 / mid as f64 } else { (dist[i] as f64 + mid as f64 - 1.0) / mid as f64 };
            }
            if time <= hour {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if left == 10000000 { -1 } else { left as i32 }
    }
}