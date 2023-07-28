impl Solution {
    pub fn minimum_cost(cost: Vec<i32>) -> i32 {
        
        let mut cost = cost;
        cost.sort();
        let mut sum = 0;
        for i in (0..cost.len()).step_by(3) {
            sum += cost[i];
        }
        sum
    }
}