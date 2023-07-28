impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        

        let n = gas.len();
        let mut ans = -1;
        let mut i = 0;
        while i < n {
            let mut j = i;
            let mut sum = 0;
            while j < n + i {
                let k = j % n;
                sum += gas[k] - cost[k];
                if sum < 0 {
                    break;
                }
                j += 1;
            }
            if j == n + i {
                ans = i as i32;
                break;
            } else {
                i = j + 1;
            }
        }
        ans
    }
}