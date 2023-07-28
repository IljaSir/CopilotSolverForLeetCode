impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let n = gas.len();
        let mut gas = gas;
        let mut cost = cost;
        let mut start = 0;
        let mut end = 1;
        let mut cur_gas = gas[0] - cost[0];
        while start != end || cur_gas < 0 {
            while cur_gas < 0 && start != end {
                cur_gas -= gas[start] - cost[start];
                start = (start + 1) % n;
                if start == 0 {
                    return -1;
                }
            }
            cur_gas += gas[end] - cost[end];
            end = (end + 1) % n;
        }
        start as i32
    }
}