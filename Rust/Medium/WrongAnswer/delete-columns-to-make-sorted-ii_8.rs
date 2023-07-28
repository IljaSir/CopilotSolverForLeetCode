impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut res = 0;
        let n = strs.len();
        let m = strs[0].len();
        let mut sorted = vec![false; n];
        for j in 0..m {
            let mut sorted2 = sorted.clone();
            for i in 0..n - 1 {
                if !sorted[i] && strs[i].chars().nth(j).unwrap() > strs[i + 1].chars().nth(j).unwrap() {
                    res += 1;
                    break;
                } else if !sorted[i] && strs[i].chars().nth(j).unwrap() < strs[i + 1].chars().nth(j).unwrap() {
                    sorted2[i] = true;
                }
            }
            sorted = sorted2;
        }
        res
    }
}