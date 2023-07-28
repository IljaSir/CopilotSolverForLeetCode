impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut prev = 0;
        for i in 0..target.len() {
            if target[i] > prev {
                res += target[i] - prev;
            }
            prev = target[i];
        }
        res
    }
}