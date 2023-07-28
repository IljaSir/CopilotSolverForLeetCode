impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        
        let (mut l, mut r) = (1, 500 * weights.len() as i32);
        while l < r {
            let mid = (l + r) / 2;
            let mut t = 0;
            let mut d = 0;
            for &w in weights.iter() {
                if t + w > mid {
                    t = 0;
                    d += 1;
                }
                t += w;
            }
            if t > 0 {
                d += 1;
            }
            if d > days {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}