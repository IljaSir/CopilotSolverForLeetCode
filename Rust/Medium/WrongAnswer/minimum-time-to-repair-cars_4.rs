impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort();
        let mut l = 0;
        let mut r = 1_000_000_000;
        while l < r {
            let mid = (l + r) / 2;
            let mut t = 0;
            for &r in &ranks {
                t += r as i64 * (mid / (r as i64 * r as i64));
            }
            if t >= cars as i64 {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l as i64
    }
}