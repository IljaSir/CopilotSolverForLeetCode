impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut sum = 0;
        let mut day = 1;
        let mut week = 1;
        for i in 0..n {
            sum += day;
            day += 1;
            if (i + 1) % 7 == 0 {
                day = ++week;
            }
        }
        sum
    }
}