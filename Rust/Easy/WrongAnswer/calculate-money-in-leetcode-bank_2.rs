impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut week = 1;
        let mut day = 1;
        for _ in 0..n {
            sum += day;
            day += 1;
            if day == 8 {
                day = 1;
                week += 1;
            }
            if day == 2 {
                day += week;
            }
        }
        sum
    }
}