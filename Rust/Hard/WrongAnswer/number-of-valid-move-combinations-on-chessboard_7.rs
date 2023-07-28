impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 1;
        for (i, p) in pieces.iter().enumerate() {
            let mut r = positions[i][0];
            let mut c = positions[i][1];
            let mut cnt = 0;
            if p == "rook" {
                cnt = 14;
                for j in 0..positions.len() {
                    if i == j {
                        continue;
                    }
                    let r1 = positions[j][0];
                    let c1 = positions[j][1];
                    if r == r1 || c == c1 {
                        cnt -= 1;
                    }
                }
            } else if p == "queen" {
                cnt = 21;
                for j in 0..positions.len() {
                    if i == j {
                        continue;
                    }
                    let r1 = positions[j][0];
                    let c1 = positions[j][1];
                    if r == r1 || c == c1 || (r1 - r).abs() == (c1 - c).abs() {
                        cnt -= 1;
                    }
                }
            } else {
                cnt = 11;
                for j in 0..positions.len() {
                    if i == j {
                        continue;
                    }
                    let r1 = positions[j][0];
                    let c1 = positions[j][1];
                    if (r1 - r).abs() == (c1 - c).abs() {
                        cnt -= 1;
                    }
                }
            }
            ans *= cnt;
        }
        ans
    }
}