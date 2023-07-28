impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let n = gas.len();
        let mut total = 0;
        let mut cur = 0;
        let mut start = 0;
        for i in 0..n {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if cur < 0 {
                start = i + 1;
                cur = 0;
            }
        }
        if total >= 0 {
            start as i32
        } else {
            -1
        }
    }
}