impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut n = n;
        while n > 0 {
            let mut next = vec![0; 8];
            for i in 1..7 {
                next[i] = if cells[i - 1] == cells[i + 1] { 1 } else { 0 };
            }
            cells = next;
            n -= 1;
            if n > 0 && cells == vec![0, 1, 0, 1, 1, 0, 0, 1] {
                n %= 14;
            }
        }
        cells
    }
}