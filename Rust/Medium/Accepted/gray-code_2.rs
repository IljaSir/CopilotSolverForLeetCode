impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut res = vec![0];
        for i in 0..n {
            let size = res.len();
            for j in (0..size).rev() {
                res.push(res[j] | 1 << i);
            }
        }
        res
    }
}