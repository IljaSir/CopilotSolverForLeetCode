impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let mut start = 0;
        let mut tank = 0;
        let mut total = 0;
        for i in 0..gas.len() {
            let diff = gas[i] - cost[i];
            tank += diff;
            if tank < 0 {
                start = i + 1;
                tank = 0;
            }
            total += diff;
        }
        if total < 0 { -1 } else { start as i32 }
    }
}