impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut total = 0;
        let mut day = 1;
        let mut week = 1;
        for _ in 0..n {
            total += day;
            day += 1;
            if day > 7 {
                day = 1;
                week += 1;
            }
            day += week - 1;
        }
        total
    }
}