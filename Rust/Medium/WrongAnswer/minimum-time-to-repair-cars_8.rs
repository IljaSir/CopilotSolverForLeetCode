impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort();
        let mut lo = 0;
        let mut hi = cars as i64;
        while lo + 1 < hi {
            let mid = (lo + hi) / 2;
            let mut cnt = 0;
            for &rank in &ranks {
                cnt += (rank as i64 * mid * mid) / 2;
            }
            if cnt >= cars as i64 {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        hi * hi
    }
}