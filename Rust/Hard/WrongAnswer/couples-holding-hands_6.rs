impl Solution {
    pub fn min_swaps_couples(row: Vec<i32>) -> i32 {
        
        let mut row = row;
        let mut swaps = 0;
        for i in 0..row.len() / 2 {
            let couple = row[2 * i] / 2 * 2;
            if row[2 * i + 1] == couple + 1 {
                continue;
            }
            swaps += 1;
            for j in 2 * i + 2..row.len() {
                if row[j] == couple + 1 {
                    row[j] = row[2 * i + 1];
                    row[2 * i + 1] = couple + 1;
                    break;
                }
            }
        }
        swaps
    }
}