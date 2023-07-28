impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        if m * k > bloom_day.len() as i32 {
            return -1;
        }
        let (mut l, mut r) = (bloom_day.iter().min().unwrap(), bloom_day.iter().max().unwrap());
        while l < r {
            let mid = (l + r) / 2;
            let mut bouquets = 0;
            let mut flowers = 0;
            for &d in bloom_day.iter() {
                if d <= mid {
                    flowers += 1;
                    if flowers == k {
                        bouquets += 1;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if bouquets >= m {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        *l
    }
}