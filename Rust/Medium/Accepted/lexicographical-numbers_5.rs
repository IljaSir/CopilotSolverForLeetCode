impl Solution {
    pub fn lexical_order(n: i32) -> Vec<i32> {
        

        let mut res = Vec::new();
        for i in 1..10 {
            if i > n {
                break;
            }
            res.push(i);
            Self::dfs(i, n, &mut res);
        }
        res
    }
    fn dfs(i: i32, n: i32, res: &mut Vec<i32>) {
        for j in 0..10 {
            let k = i * 10 + j;
            if k > n {
                break;
            }
            res.push(k);
            Self::dfs(k, n, res);
        }
    }
}