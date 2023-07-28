impl Solution {
    pub fn min_swaps_couples(row: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut row = row;
        for i in 0..row.len() / 2 {
            if row[2 * i] / 2 == row[2 * i + 1] / 2 {
                continue;
            }
            let mut j = 2 * i + 1;
            while row[j] / 2 != row[2 * i] / 2 {
                j += 1;
            }
            row.swap(j, 2 * i + 1);
            count += 1;
        }
        count
    }
}