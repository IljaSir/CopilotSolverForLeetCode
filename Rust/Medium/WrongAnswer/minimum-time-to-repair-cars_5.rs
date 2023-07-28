impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort_unstable();
        let mut l = 0;
        let mut r = 1_000_000_000;
        while l < r {
            let m = (l + r) / 2;
            let mut cnt = 0;
            for &rank in &ranks {
                cnt += m / (rank * rank) as i32;
                if cnt >= cars {
                    break;
                }
            }
            if cnt >= cars {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l as i64
    }
}