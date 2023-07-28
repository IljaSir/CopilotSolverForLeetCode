impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort();
        let mut lo = 1;
        let mut hi = cars as i64;
        while lo < hi {
            let mid = (lo + hi) / 2;
            let mut total = 0;
            for &r in ranks.iter() {
                total += r as i64 * mid * mid;
                if total > cars as i64 {
                    break;
                }
            }
            if total > cars as i64 {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo * lo * ranks[0] as i64
    }
}