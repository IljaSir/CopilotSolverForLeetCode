impl Solution {
    pub fn find_min_moves(machines: Vec<i32>) -> i32 {
        
        let sum = machines.iter().sum::<i32>();
        if sum % machines.len() as i32 != 0 {
            return -1;
        }
        let avg = sum / machines.len() as i32;
        let mut count = 0;
        let mut res = 0;
        for i in 0..machines.len() {
            count += machines[i] - avg;
            let tmp = (count as i64).abs() as i32;
            res = res.max(tmp);
            if count < 0 {
                res = res.max(machines[i] - avg);
            }
        }
        res
    }
}