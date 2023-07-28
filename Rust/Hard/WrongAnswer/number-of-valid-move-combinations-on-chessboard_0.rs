impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 1;
        let n = pieces.len();
        for i in 0..n {
            let x = positions[i][0] as usize;
            let y = positions[i][1] as usize;
            let mut cnt = 0;
            if pieces[i] == "rook" {
                cnt = 14;
            } else if pieces[i] == "bishop" {
                cnt = 12;
            } else {
                cnt = 22;
            }
            for j in 0..n {
                if i == j {
                    continue;
                }
                let x1 = positions[j][0] as usize;
                let y1 = positions[j][1] as usize;
                if x == x1 || y == y1 {
                    cnt -= 1;
                }
                if (x + y) % 2 == (x1 + y1) % 2 {
                    if (x + y) == (x1 + y1) || (x - y) == (x1 - y1) {
                        cnt -= 1;
                    }
                }
            }
            ans *= cnt;
        }
        ans as i32
    }
}