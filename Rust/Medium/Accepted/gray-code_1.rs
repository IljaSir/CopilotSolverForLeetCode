impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut res = vec![0];
        for i in 0..n {
            let inc = 1 << i;
            for j in (0..res.len()).rev() {
                res.push(res[j] + inc);
            }
        }
        res
    }
}