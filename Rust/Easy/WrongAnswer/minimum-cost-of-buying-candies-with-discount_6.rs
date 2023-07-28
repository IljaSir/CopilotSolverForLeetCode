impl Solution {
    pub fn minimum_cost(cost: Vec<i32>) -> i32 {
        
        let mut cost = cost;
        cost.sort();
        let mut sum = 0;
        for i in 0..cost.len() {
            if i % 2 == 0 {
                sum += cost[i];
            }
        }
        sum
    }
}