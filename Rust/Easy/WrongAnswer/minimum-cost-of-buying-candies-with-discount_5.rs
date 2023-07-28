impl Solution {
    pub fn minimum_cost(cost: Vec<i32>) -> i32 {
        
        let mut cost = cost;
        cost.sort();
        let mut ans = 0;
        for i in (0..cost.len()).step_by(3) {
            ans += cost[i];
        }
        ans
    }
}