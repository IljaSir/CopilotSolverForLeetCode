impl Solution {
    pub fn good_days_to_rob_bank(security: Vec<i32>, time: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut len = security.len();
        let mut i = time as usize;
        while i < len - time as usize {
            let mut j = i - 1;
            let mut k = i + 1;
            let mut flag = true;
            while j >= i - time as usize {
                if security[j] < security[j + 1] {
                    flag = false;
                    break;
                }
                j -= 1;
            }
            if !flag {
                i += 1;
                continue;
            }
            while k <= i + time as usize {
                if security[k] < security[k - 1] {
                    flag = false;
                    break;
                }
                k += 1;
            }
            if !flag {
                i += 1;
                continue;
            }
            res.push(i as i32);
            i += 1;
        }
        res
    }
}