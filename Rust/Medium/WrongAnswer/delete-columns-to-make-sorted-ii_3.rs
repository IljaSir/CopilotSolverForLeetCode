impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut strs: Vec<Vec<char>> = strs.iter().map(|s| s.chars().collect()).collect();
        let mut res = 0;
        for i in 0..strs[0].len() {
            let mut sorted = true;
            for j in 1..strs.len() {
                if strs[j][i] < strs[j-1][i] {
                    sorted = false;
                    break;
                }
            }
            if !sorted {
                res += 1;
            } else {
                for j in 1..strs.len() {
                    if strs[j][i] > strs[j-1][i] {
                        strs[j-1][i] = ' ';
                    }
                }
            }
        }
        res
    }
}