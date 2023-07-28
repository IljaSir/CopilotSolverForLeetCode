impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut res = 0;
        let n = strs[0].len();
        let m = strs.len();
        for i in 0..n {
            let mut flag = false;
            for j in 1..m {
                if strs[j].chars().nth(i).unwrap() < strs[j - 1].chars().nth(i).unwrap() {
                    flag = true;
                    break;
                }
            }
            if flag {
                res += 1;
            }
        }
        res
    }
}