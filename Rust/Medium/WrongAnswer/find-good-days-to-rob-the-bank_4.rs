impl Solution {
    pub fn good_days_to_rob_bank(security: Vec<i32>, time: i32) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = time as usize;
        while j < security.len() {
            let mut k = i;
            let mut is_good = true;
            while k < i + time as usize {
                if security[k] > security[k + 1] {
                    is_good = false;
                    break;
                }
                k += 1;
            }
            if is_good {
                k = j;
                while k > j - time as usize {
                    if security[k] > security[k - 1] {
                        is_good = false;
                        break;
                    }
                    k -= 1;
                }
            }
            if is_good {
                result.push(i as i32);
            }
            i += 1;
            j += 1;
        }
        result
    }
}