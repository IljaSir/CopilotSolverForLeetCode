impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 1 {
                    let mut flag = true;
                    for ii in 0..mat.len() {
                        if ii != i && mat[ii][j] != 0 {
                            flag = false;
                            break;
                        }
                    }
                    if flag {
                        for jj in 0..mat[i].len() {
                            if jj != j && mat[i][jj] != 0 {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if flag {
                        ans += 1;
                    }
                }
            }
        }
        ans
    }
}