impl Solution {
    pub fn good_days_to_rob_bank(security: Vec<i32>, time: i32) -> Vec<i32> {
        
        let time = time as usize;
        let mut res = vec![];
        let n = security.len();
        for i in time..n-time {
            let mut good = true;
            for j in 1..=time {
                if security[i-j] < security[i-j+1] {
                    good = false;
                    break;
                }
            }
            if !good { continue; }
            for j in 1..=time {
                if security[i+j-1] > security[i+j] {
                    good = false;
                    break;
                }
            }
            if good { res.push(i as i32); }
        }
        res
    }
}