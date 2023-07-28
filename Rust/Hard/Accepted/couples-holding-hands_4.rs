impl Solution {
    pub fn min_swaps_couples(row: Vec<i32>) -> i32 {
        
        let mut row = row;
        let mut res = 0;
        for i in 0..row.len() / 2 {
            if row[2 * i + 1] == row[2 * i] ^ 1 {
                continue;
            }
            for j in 2 * i + 2..row.len() {
                if row[j] == row[2 * i] ^ 1 {
                    row.swap(j, 2 * i + 1);
                    break;
                }
            }
            res += 1;
        }
        res
    }
}