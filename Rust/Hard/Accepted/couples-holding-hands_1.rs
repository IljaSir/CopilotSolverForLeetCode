impl Solution {
    pub fn min_swaps_couples(row: Vec<i32>) -> i32 {
        
        let mut row = row;
        let mut ans = 0;
        for i in (0..row.len()).step_by(2) {
            if row[i] % 2 == 0 {
                if row[i + 1] != row[i] + 1 {
                    let mut j = i + 1;
                    while row[j] != row[i] + 1 {
                        j += 1;
                    }
                    row.swap(i + 1, j);
                    ans += 1;
                }
            } else {
                if row[i + 1] != row[i] - 1 {
                    let mut j = i + 1;
                    while row[j] != row[i] - 1 {
                        j += 1;
                    }
                    row.swap(i + 1, j);
                    ans += 1;
                }
            }
        }
        ans
    }
}