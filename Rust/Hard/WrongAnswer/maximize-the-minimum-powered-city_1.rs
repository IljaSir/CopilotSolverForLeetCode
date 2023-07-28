impl Solution {
    pub fn max_power(stations: Vec<i32>, r: i32, k: i32) -> i64 {
        
        let mut stations = stations;
        stations.sort();
        let mut l = 1;
        let mut r = stations[stations.len() - 1] - stations[0] + 1;
        while l < r {
            let mid = (l + r) / 2;
            let mut need = 0;
            for i in 0..stations.len() - 1 {
                let d = stations[i+1] - stations[i];
                need += (d - 1) / (2 * r + 1);
            }
            if need > k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l as i64
    }
}