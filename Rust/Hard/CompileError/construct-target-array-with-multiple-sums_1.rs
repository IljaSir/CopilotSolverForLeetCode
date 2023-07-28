impl Solution {
    pub fn is_possible(target: Vec<i32>) -> bool {
        
        let mut target = target;
        let n = target.len();
        let mut sum: i64 = target.iter().map(|x| *x as i64).sum();
        let mut max = target.iter().max().unwrap();
        while sum > n as i64 {
            let max = max.clone();
            let x = sum - max.clone() as i64;
            if x == 1 {
                return true;
            }
            sum -= max.clone() as i64;
            max = (max - x) as i32;
            if max < 1 {
                return false;
            }
            sum += max.clone() as i64;
            let mut i = 0;
            while i < n {
                if target[i] == max {
                    break;
                }
                i += 1;
            }
            if i == n {
                return false;
            }
            target[i] = max;
        }
        true
    }
}