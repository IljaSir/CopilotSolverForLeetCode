impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        let n = dist.len();
        let mut l = 1;
        let mut r = 10_000_000;
        while l < r {
            let mid = (l + r) / 2;
            let time: f64 = dist[..n - 1].iter().map(|&x| (x + mid - 1) / mid).sum();
            let time = time + dist[n - 1] as f64 / mid as f64;
            if time > hour {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if l < 10_000_000 {
            l as i32
        } else {
            -1
        }
    }
}