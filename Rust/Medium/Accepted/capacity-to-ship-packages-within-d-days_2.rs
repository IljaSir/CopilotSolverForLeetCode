impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        for w in weights.iter() {
            l = l.max(*w);
            r += w;
        }
        while l < r {
            let m = l + (r - l) / 2;
            let mut d = 1;
            let mut s = 0;
            for w in weights.iter() {
                if s + w > m {
                    d += 1;
                    s = 0;
                }
                s += w;
            }
            if d > days {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l
    }
}