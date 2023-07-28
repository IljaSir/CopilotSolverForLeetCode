impl Solution {
    pub fn product_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut powers = vec![];
        let mut n = n;
        while n > 0 {
            powers.push(n);
            n &= n - 1;
        }
        let mut prod = vec![1];
        let mut acc = 1;
        for i in powers.iter() {
            acc = acc * i % 1000000007;
            prod.push(acc);
        }
        let mut res = vec![];
        for q in queries.iter() {
            let (left, right) = (q[0] as usize, q[1] as usize);
            res.push(prod[right + 1] * (prod[left] as i32).pow(1000000005) % 1000000007);
        }
        res
    }
}