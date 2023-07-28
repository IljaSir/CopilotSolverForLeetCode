impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut week = 0;
        let mut day = 1;
        for i in 1..=n {
            sum += week + day;
            day += 1;
            if i % 7 == 0 {
                week += 1;
                day = 1;
            }
        }
        sum
    }
}