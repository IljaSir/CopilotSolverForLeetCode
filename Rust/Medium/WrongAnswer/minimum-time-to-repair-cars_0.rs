impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort();
        let mut l = 0;
        let mut r = ranks[ranks.len() - 1] as i64 * cars as i64 * cars as i64;
        while l < r {
            let m = (l + r) / 2;
            let mut c = 0;
            for r in ranks.iter() {
                c += m / (*r as i64 * *r as i64);
            }
            if c >= cars as i64 {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}