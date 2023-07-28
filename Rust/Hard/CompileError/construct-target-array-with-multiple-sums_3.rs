impl Solution {
    pub fn is_possible(target: Vec<i32>) -> bool {
        
        let mut target = target;
        let mut sum: i64 = target.iter().map(|x| *x as i64).sum();
        let mut max = *target.iter().max().unwrap();
        let mut max_i = target.iter().position(|x| *x == max).unwrap();
        while max > 1 {
            let rest = sum - max;
            if rest == 1 {
                return true;
            }
            let new = max % rest;
            if new == 0 || new == max {
                return false;
            }
            sum = sum - max + new;
            max = new;
            target[max_i] = new;
            max_i = target.iter().position(|x| *x == max).unwrap();
        }
        true
    }
}