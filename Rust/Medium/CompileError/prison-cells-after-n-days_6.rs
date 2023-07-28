impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut seen = Vec::new();
        let mut n = n;
        while n > 0 {
            let mut cells2 = cells.clone();
            seen.push(cells);
            cells2[0] = 0;
            cells2[7] = 0;
            for i in 1..7 {
                cells2[i] = if cells[i-1] == cells[i+1] { 1 } else { 0 }
            }
            cells = cells2;
            n -= 1;
            if let Some(i) = seen.iter().position(|x| x == &cells) {
                n %= seen.len() - i;
            }
        }
        cells
    }
}