impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        for w in weights.iter() {
            l = l.max(*w);
            r += w;
        }
        while l < r {
            let mid = l + (r - l) / 2;
            let mut need = 1;
            let mut cur = 0;
            for w in weights.iter() {
                if cur + w > mid {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if need <= days {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l
    }
}