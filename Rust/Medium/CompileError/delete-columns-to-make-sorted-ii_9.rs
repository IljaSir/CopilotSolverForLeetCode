impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut strs = strs;
        let m = strs.len();
        let n = strs[0].len();
        let mut count = 0;
        for j in 0..n {
            let mut flag = true;
            for i in 1..m {
                if strs[i].as_bytes()[j] < strs[i - 1].as_bytes()[j] {
                    flag = false;
                    break;
                }
            }
            if !flag {
                count += 1;
            } else {
                for i in 1..m {
                    strs[i].as_bytes_mut()[j] = strs[i - 1].as_bytes()[j];
                }
            }
        }
        count
    }
}