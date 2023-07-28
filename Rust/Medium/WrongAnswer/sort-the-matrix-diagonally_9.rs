impl Solution {
    pub fn diagonal_sort(mat: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut m = mat;
        let r = m.len();
        let c = m[0].len();
        for i in 0..r {
            let mut v: Vec<i32> = m[i].iter().map(|x| *x).collect();
            v.sort();
            m[i] = v;
        }
        for j in 0..c {
            let mut v: Vec<i32> = vec![];
            for i in 0..r {
                if j + i < c {
                    v.push(m[i][j + i]);
                }
            }
            v.sort();
            for i in 0..r {
                if j + i < c {
                    m[i][j + i] = v[i];
                }
            }
        }
        m
    }
}