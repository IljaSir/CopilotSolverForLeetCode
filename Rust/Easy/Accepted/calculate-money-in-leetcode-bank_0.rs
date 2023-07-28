impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut total = 0;
        let mut week = 1;
        let mut day = 1;
        for i in 1..=n {
            total += day;
            day += 1;
            if i % 7 == 0 {
                week += 1;
                day = week;
            }
        }
        total
    }
}