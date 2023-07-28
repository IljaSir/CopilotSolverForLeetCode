impl Solution {
    pub fn repair_cars(ranks: Vec<i32>, cars: i32) -> i64 {
        
        let mut ranks = ranks;
        ranks.sort();
        let mut l = 0i64;
        let mut r = 1i64 << 32;
        while l < r {
            let m = l + (r - l) / 2;
            let mut cnt = 0i64;
            for &rank in &ranks {
                let mut k = 1i64;
                while cnt + k * k * rank as i64 <= m {
                    cnt += k * k * rank as i64;
                    k *= 2;
                }
            }
            if cnt >= cars as i64 {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}