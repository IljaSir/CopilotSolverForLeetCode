impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut n = n;
        let mut seen = vec![vec![0; 8]; 14];
        let mut i = 0;
        while n > 0 {
            let mut next = vec![0; 8];
            for j in 1..7 {
                next[j] = (cells[j - 1] == cells[j + 1]) as i32;
            }
            if seen[0] == next {
                n %= i;
            } else {
                seen[i] = next;
                i += 1;
            }
            cells = next;
            n -= 1;
        }
        cells
    }
}