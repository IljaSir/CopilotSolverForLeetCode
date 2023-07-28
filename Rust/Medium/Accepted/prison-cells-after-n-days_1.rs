impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut n = n;
        let mut seen = vec![];
        while n > 0 {
            let mut next = vec![0; 8];
            for i in 1..7 {
                next[i] = if cells[i - 1] == cells[i + 1] { 1 } else { 0 };
            }
            if seen.contains(&next) {
                n %= seen.len() as i32;
            } else {
                seen.push(next.clone());
            }
            if n > 0 {
                n -= 1;
                cells = next;
            }
        }
        cells
    }
}