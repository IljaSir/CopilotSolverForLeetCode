impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let n = gas.len();
        let mut gas_left = 0;
        let mut min_gas_left = i32::MAX;
        let mut min_gas_left_idx = 0;
        for i in 0..n {
            gas_left += gas[i] - cost[i];
            if gas_left < min_gas_left {
                min_gas_left = gas_left;
                min_gas_left_idx = i;
            }
        }
        if gas_left < 0 {
            -1
        } else {
            (min_gas_left_idx + 1) as i32 % n as i32
        }
    }
}