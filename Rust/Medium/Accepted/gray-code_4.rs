impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut res = vec![0];
        for i in 0..n {
            let add = 1 << i;
            let l = res.len();
            for j in (0..l).rev() {
                res.push(add + res[j]);
            }
        }
        res
    }
}