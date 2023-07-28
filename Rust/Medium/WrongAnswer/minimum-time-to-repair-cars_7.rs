impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort();
        let mut l = 0;
        let mut r = 1_000_000_000;
        while l < r {
            let m = (l + r) >> 1;
            let mut cnt = 0;
            for rank in ranks.iter() {
                cnt += *rank as i64 * m * m;
                if cnt >= cars as i64 {
                    break;
                }
            }
            if cnt >= cars as i64 {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l as i64
    }
}