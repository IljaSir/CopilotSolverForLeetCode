impl Solution {
    pub fn minimum_money(transactions: Vec<Vec<i32>>) -> i64 {
        
        let mut ans = 0;
        let mut money = 0;
        let mut c = 0;
        for t in transactions {
            ans += t[0] as i64;
            money += t[1] as i64;
            c = c.max(t[0] - t[1]);
        }
        ans - money + c as i64
    }
}