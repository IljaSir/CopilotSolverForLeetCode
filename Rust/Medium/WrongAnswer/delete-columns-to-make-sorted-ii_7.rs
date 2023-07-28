impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut prev = strs[0].chars().collect::<Vec<char>>();
        for i in 1..strs.len() {
            let mut curr = strs[i].chars().collect::<Vec<char>>();
            for j in 0..curr.len() {
                if curr[j] < prev[j] {
                    count += 1;
                    break;
                }
                if curr[j] > prev[j] {
                    prev[j] = curr[j];
                }
            }
        }
        count
    }
}