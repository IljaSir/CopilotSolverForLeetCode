impl Solution {
    pub fn gray_code(n: i32) -> Vec<i32> {
        

        let mut res: Vec<i32> = vec![];
        let mut i = 0;
        while i < 1 << n {
            res.push(i ^ (i >> 1));
            i += 1;
        }
        res
    }
}