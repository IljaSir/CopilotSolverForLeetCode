impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        // The pattern repeats every 14 days.
        // The first day and the 15th day are the same.
        let mut cells = cells;
        let mut n = n % 14;
        if n == 0 {
            n = 14;
        }
        for _ in 0..n {
            let mut next = vec![0; 8];
            for i in 1..7 {
                next[i] = (cells[i - 1] == cells[i + 1]) as i32;
            }
            cells = next;
        }
        cells
    }
}