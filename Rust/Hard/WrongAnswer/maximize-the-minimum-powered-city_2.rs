impl Solution {
    pub fn max_power(stations: Vec<i32>, r: i32, k: i32) -> i64 {
        
        let n = stations.len();
        let mut stations = stations;
        stations.sort();
        let mut l = 0;
        let mut r = 1_000_000_000;
        while l < r {
            let mid = (l + r + 1) / 2;
            let mut cnt = 0;
            for i in 1..n {
                let d = stations[i] - stations[i - 1];
                if d > 2 * r {
                    return -1;
                }
                if d > 2 * r - mid {
                    cnt += (d - 2 * r + mid + mid - 1) / mid;
                }
            }
            if cnt <= k {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        l as i64
    }
}