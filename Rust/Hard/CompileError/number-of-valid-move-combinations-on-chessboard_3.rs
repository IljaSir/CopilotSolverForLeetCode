impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 1;
        for i in 0..pieces.len() {
            let p = &pieces[i];
            let pos = &positions[i];
            let x = pos[0] as usize;
            let y = pos[1] as usize;
            let mut cnt = 0;
            if p == "rook" {
                cnt = 14;
                for j in 0..pieces.len() {
                    let p2 = &pieces[j];
                    let pos2 = &positions[j];
                    let x2 = pos2[0] as usize;
                    let y2 = pos2[1] as usize;
                    if p2 == "rook" {
                        if x == x2 || y == y2 {
                            cnt -= 1;
                        }
                    } else if p2 == "queen" {
                        if x == x2 || y == y2 {
                            cnt -= 1;
                        } else if x + y == x2 + y2 || x - y == x2 - y2 {
                            cnt -= 1;
                        }
                    } else {
                        if x + y == x2 + y2 || x - y == x2 - y2 {
                            cnt -= 1;
                        }
                    }
                }
            } else if p == "queen" {
                cnt = 21;
                for j in 0..pieces.len() {
                    let p2 = &pieces[j];
                    let pos2 = &positions[j];
                    let x2 = pos2[0] as usize;
                    let y2 = pos2[1] as usize;
                    if p2 == "rook" {
                        if x == x2 || y == y2 {
                            cnt -= 1;
                        }
                    } else if p2 == "queen" {
                        if x == x2 || y == y2 {
                            cnt -= 1;
                        } else if x + y == x2 + y2 || x - y == x2 - y2 {
                            cnt -= 1;
                        }
                    } else {
                        if x + y == x2 + y2 || x - y == x2 - y2 {
                            cnt -= 1;
                        }
                    }
                }
            } else {
                cnt = 11;
                for j in 0..pieces.len() {
                    let p2 = &pieces[j];
                    let pos2 =
    }
}