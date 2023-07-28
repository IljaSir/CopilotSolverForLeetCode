impl Solution {
    pub fn num_special(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] == 1 {
                    let mut flag = true;
                    for k in 0..mat.len() {
                        if k == i {
                            continue;
                        }
                        if mat[k][j] == 1 {
                            flag = false;
                            break;
                        }
                    }
                    if flag {
                        for k in 0..mat[i].len() {
                            if k == j {
                                continue;
                            }
                            if mat[i][k] == 1 {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if flag {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}