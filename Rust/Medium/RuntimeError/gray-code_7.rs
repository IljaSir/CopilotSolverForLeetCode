impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut res = vec![0];
        for i in 0..n {
            let mut inc = 1 << i;
            let mut j = res.len() - 1;
            while j >= 0 {
                res.push(res[j] + inc);
                j -= 1;
            }
        }
        res
    }
}