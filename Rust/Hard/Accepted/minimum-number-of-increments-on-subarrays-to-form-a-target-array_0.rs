impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        
        let mut res = target[0];
        for i in 1..target.len() {
            res += (target[i] - target[i - 1]).max(0);
        }
        res
    }
}