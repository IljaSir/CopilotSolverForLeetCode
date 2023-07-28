impl Solution {
    pub fn is_possible(target: Vec<i32>) -> bool {
        
        let mut target = target;
        let mut sum = target.iter().sum();
        for _ in 0..target.len() {
            let mut max = 0;
            let mut max_index = 0;
            for (i, &v) in target.iter().enumerate() {
                if v > max {
                    max = v;
                    max_index = i;
                }
            }
            sum -= max;
            if max == 1 || sum == 1 {
                return true;
            }
            if max < sum || sum == 0 || max % sum == 0 {
                return false;
            }
            target[max_index] %= sum;
            sum += target[max_index];
        }
        false
    }
}