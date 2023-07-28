impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let n = gas.len();
        let mut start = 0;
        let mut total = 0;
        let mut sum = 0;
        for i in 0..n {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if sum < 0 {
                start = i + 1;
                sum = 0;
            }
        }
        if total >= 0 {
            start as i32
        } else {
            -1
        }
    }
}