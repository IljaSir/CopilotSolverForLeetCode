impl Solution {
    pub fn min_speed_on_time(dist: Vec<i32>, hour: f64) -> i32 {
        
        if dist.len() as f64 - 1.0 > hour {
            return -1;
        }
        let mut l = 1;
        let mut r = 10_000_000;
        while l < r {
            let m = l + (r - l) / 2;
            if Solution::check(&dist, m, hour) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    fn check(dist: &Vec<i32>, speed: i32, hour: f64) -> bool {
        let mut res = 0.0;
        for i in 0..dist.len() - 1 {
            res += (dist[i] as f64 / speed as f64).ceil();
        }
        res += dist.last().unwrap() as f64 / speed as f64;
        return res <= hour;
    }
}