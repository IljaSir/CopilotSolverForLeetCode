impl Solution {
    pub fn prison_after_n_days(cells: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut cells = cells;
        let mut n = n;
        let mut seen = vec![];
        let mut cycle = 0;
        while n > 0 {
            let mut next = vec![0; 8];
            for i in 1..7 {
                next[i] = if cells[i - 1] == cells[i + 1] { 1 } else { 0 };
            }
            if seen.contains(&next) {
                cycle = seen.len() - seen.iter().position(|x| x == &next).unwrap();
                break;
            } else {
                seen.push(next.clone());
            }
            cells = next;
            n -= 1;
        }
        while n > 0 {
            let mut next = vec![0; 8];
            for i in 1..7 {
                next[i] = if cells[i - 1] == cells[i + 1] { 1 } else { 0 };
            }
            cells = next;
            n -= 1;
        }
        cells
    }
}