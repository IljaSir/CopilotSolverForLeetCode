impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        let mut l = 1;
        let mut r = 10_i64.pow(7);
        let mut ans = -1;
        while l <= r {
            let mid = (l + r) / 2;
            let mut time = 0.0;
            for i in 0..n {
                if i == n - 1 {
                    time += dist[i] as f64 / mid as f64;
                } else {
                    time += (dist[i] as f64 / mid as f64).ceil();
                }
            }
            if time <= hour {
                ans = mid as i32;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        ans
    }
}