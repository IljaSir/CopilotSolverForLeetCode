impl Solution {
    pub fn min_swaps_couples(row: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut pos = vec![0; row.len()];
        for i in 0..row.len() {
            pos[row[i] as usize] = i;
        }
        for i in (0..row.len()).step_by(2) {
            if row[i] % 2 == 0 {
                if row[i + 1] != row[i] + 1 {
                    let j = pos[row[i] as usize + 1];
                    pos[row[i + 1] as usize] = j;
                    row.swap(i + 1, j);
                    ans += 1;
                }
            } else {
                if row[i + 1] != row[i] - 1 {
                    let j = pos[row[i] as usize - 1];
                    pos[row[i + 1] as usize] = j;
                    row.swap(i + 1, j);
                    ans += 1;
                }
            }
        }
        ans
    }
}