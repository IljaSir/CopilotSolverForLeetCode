impl Solution {
    pub fn mincost_tickets(days: Vec<i32>, costs: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; days.len() + 1];
        let mut j = 0;
        for i in 1..=365 {
            if j == days.len() {
                break;
            }
            if i == days[j] {
    }
}