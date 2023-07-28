impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![0; n as usize]; n as usize];
        let mut r = 0;
        let mut c = 0;
        let mut d = 0;
        let mut i = 1;
        while i <= n * n {
            res[r][c] = i;
            i += 1;
            match d {
                0 => {
                    if c == n as usize - 1 || res[r][c + 1] != 0 {
                        d = 1;
                        r += 1;
                    } else {
                        c += 1;
                    }
                }
                1 => {
                    if r == n as usize - 1 || res[r + 1][c] != 0 {
                        d = 2;
                        c -= 1;
                    } else {
                        r += 1;
                    }
                }
                2 => {
                    if c == 0 || res[r][c - 1] != 0 {
                        d = 3;
                        r -= 1;
                    } else {
                        c -= 1;
                    }
                }
                3 => {
                    if r == 0 || res[r - 1][c] != 0 {
                        d = 0;
                        c += 1;
                    } else {
                        r -= 1;
                    }
                }
                _ => {}
            }
        }
        res
    }
}