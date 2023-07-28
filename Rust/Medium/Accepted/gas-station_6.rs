impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let n = gas.len();
        let mut start = 0;
        let mut end = 0;
        let mut sum = 0;
        while start < n {
            while sum >= 0 && end < n + start {
                let i = end % n;
                sum += gas[i] - cost[i];
                end += 1;
            }
            if sum >= 0 {
                return start as i32;
            }
            sum -= gas[start] - cost[start];
            start += 1;
        }
        -1
    }
}