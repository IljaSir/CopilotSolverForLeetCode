impl Solution {
    pub fn minimum_cost(cost: Vec<i32>) -> i32 {
        
        let mut cost = cost;
        cost.sort();
        let mut res = 0;
        let mut i = 0;
        while i < cost.len() {
            if i + 1 < cost.len() {
                res += cost[i] + cost[i + 1];
                i += 3;
            } else {
                res += cost[i];
                i += 1;
            }
        }
        res
    }
}