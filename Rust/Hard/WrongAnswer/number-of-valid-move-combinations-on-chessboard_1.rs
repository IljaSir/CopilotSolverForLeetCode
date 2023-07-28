impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 1;
        let n = pieces.len();
        for i in 0..n {
            let (x, y) = (positions[i][0] - 1, positions[i][1] - 1);
            let mut cnt = 0;
            for j in 0..n {
                if i == j {
                    continue;
                }
                let (x1, y1) = (positions[j][0] - 1, positions[j][1] - 1);
                if pieces[i] == "rook" {
                    if x == x1 || y == y1 {
                        cnt += 1;
                    }
                } else if pieces[i] == "bishop" {
                    if (x - x1).abs() == (y - y1).abs() {
                        cnt += 1;
                    }
                } else {
                    if x == x1 || y == y1 || (x - x1).abs() == (y - y1).abs() {
                        cnt += 1;
                    }
                }
            }
            ans *= 15 - cnt;
        }
        ans as i32
    }
}