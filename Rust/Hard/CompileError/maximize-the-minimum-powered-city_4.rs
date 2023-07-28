impl Solution {
    pub fn max_power(stations: Vec<i32>, r: i32, k: i32) -> i64 {
        
        let n = stations.len();
        let mut stations = stations;
        stations.sort();
        let mut l = 0;
        let mut r = stations[n-1] - stations[0] + 1;
        while l < r {
            let mid = (l + r) / 2;
            let mut need = 0;
            for i in 0..n {
                if i > 0 && stations[i] - stations[i-1] <= 2 * r {
                    continue;
                }
                let left = stations[i] - r;
                let right = stations[i] + r;
                let mut j = i;
                while j < n && stations[j] <= right {
                    j += 1;
                }
                let cnt = (j - i + 2 * r as usize) / (2 * r as usize + 1);
                need += cnt as i32 - 1;
                i = j - 1;
            }
            if need <= k {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l as i64
    }
}