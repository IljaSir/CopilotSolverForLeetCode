impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut res = 0;
        let mut week = 0;
        let mut day = 1;
        for i in 1..=n {
            if day == 8 {
                day = 1;
                week += 1;
            }
            res += day + week;
            day += 1;
        }
        res
    }
}