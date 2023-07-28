impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut queens = queens;
        let mut king = king;
        let mut res: Vec<Vec<i32>> = Vec::new();
        let mut q: Vec<Vec<i32>> = Vec::new();
        for i in 0..queens.len() {
            if queens[i][0] == king[0] || queens[i][1] == king[1] || (queens[i][0] - queens[i][1]) == (king[0] - king[1]) || (queens[i][0] + queens[i][1]) == (king[0] + king[1]) {
                q.push(queens[i].clone());
            }
        }
        for i in 0..q.len() {
            let mut flag = true;
            for j in 0..q.len() {
                if i != j && q[i][0] == q[j][0] && q[i][1] == q[j][1] {
                    flag = false;
                    break;
                }
            }
            if flag {
                res.push(q[i].clone());
            }
        }
        res
    }
}