impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let (mut l, mut r) = (1, 10_000_000);
        while l < r {
            let mid = (l + r) / 2;
            let mut t = 0.0;
            for i in 0..dist.len() - 1 {
                t += (dist[i] as f64) / mid as f64;
                if t.ceil() > hour {
                    break;
                }
            }
            if t.ceil() <= hour {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if l > 10_000_000 {
            -1
        } else {
            l as i32
        }
    }
}