impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut ans = 0;
        let mut week = 0;
        let mut day = 1;
        for i in 0..n {
            if i % 7 == 0 && i != 0 {
                week += 1;
                day = 1;
            }
            ans += week + day;
            day += 1;
        }
        ans
    }
}