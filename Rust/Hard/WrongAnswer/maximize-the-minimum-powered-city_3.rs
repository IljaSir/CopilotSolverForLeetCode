impl Solution {
    pub fn max_power(stations: Vec<i32>, r: i32, k: i32) -> i64 {
        
        let n = stations.len();
        let mut stations = stations;
        stations.sort();
        let mut l = 0;
        let mut r = stations[n - 1];
        while l < r {
            let mid = (l + r + 1) >> 1;
            let mut count = 0;
            for i in 0..n {
                let left = stations[i] - r;
                let right = stations[i] + r;
                count += (right - left) / (2 * r + 1);
            }
            if count <= k {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        l as i64
    }
}