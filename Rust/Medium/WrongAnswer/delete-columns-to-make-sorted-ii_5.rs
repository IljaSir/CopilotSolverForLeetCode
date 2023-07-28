impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let n = strs.len();
        let m = strs[0].len();
        let mut ans = 0;
        let mut flag = vec![true; n];
        for j in 0..m {
            for i in 1..n {
                if flag[i] && strs[i].as_bytes()[j] < strs[i - 1].as_bytes()[j] {
                    ans += 1;
                    break;
                }
                if flag[i] && strs[i].as_bytes()[j] > strs[i - 1].as_bytes()[j] {
                    flag[i] = false;
                }
            }
        }
        ans
    }
}