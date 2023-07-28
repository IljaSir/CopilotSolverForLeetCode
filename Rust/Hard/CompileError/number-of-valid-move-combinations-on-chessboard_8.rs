impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let n = pieces.len();
        let mut ans = 0;
        let mut v = vec![vec![0; 8]; 8];
        let mut dfs = |pieces: &Vec<String>, positions: &Vec<Vec<i32>>, i: usize| {
            if i == n {
                ans += 1;
                return;
            }
            for j in 0..8 {
                for k in 0..8 {
                    if v[j][k] != 0 {
                        continue;
                    }
                    if pieces[i] == "rook" {
                        if v[j].iter().any(|x| *x != 0) {
                            continue;
                        }
                        if v.iter().any(|x| x[k] != 0) {
                            continue;
                        }
                    } else if pieces[i] == "bishop" {
                        for l in 0..8 {
                            for m in 0..8 {
                                if (l - j).abs() == (m - k).abs() && v[l][m] != 0 {
                                    continue;
                                }
                            }
                        }
                    } else {
                        for l in 0..8 {
                            for m in 0..8 {
                                if (l - j).abs() == (m - k).abs() && v[l][m] != 0 {
                                    continue;
                                }
                                if v[l].iter().any(|x| *x != 0) {
                                    continue;
                                }
                                if v.iter().any(|x| x[m] != 0) {
                                    continue;
                                }
                            }
                        }
                    }
                    v[j][k] = i as i32 + 1;
                    dfs(pieces, positions, i + 1);
                    v[j][k] = 0;
                }
            }
        };
        dfs(&pieces, &positions, 0);
        ans
    }
}