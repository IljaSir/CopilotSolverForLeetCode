impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut wins = vec![0; 100000];
        let mut losses = vec![0; 100000];
        for m in matches {
            wins[m[0] as usize - 1] += 1;
            losses[m[1] as usize - 1] += 1;
        }
        let mut win = vec![];
        let mut loss = vec![];
        for i in 0..wins.len() {
            if wins[i] > 0 {
                win.push((i + 1) as i32);
            }
            if losses[i] == 1 {
                loss.push((i + 1) as i32);
            }
        }
        vec![win, loss]
    }
}