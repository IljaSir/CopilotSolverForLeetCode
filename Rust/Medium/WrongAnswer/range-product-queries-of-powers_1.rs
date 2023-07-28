impl Solution {
    pub fn product_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut powers = Vec::new();
        let mut n = n;
        let mut i = 0;
        while n > 0 {
            if n & 1 == 1 {
                powers.push(i);
            }
            n >>= 1;
            i += 1;
        }
        let mut res = Vec::new();
        for query in queries {
            let mut prod = 1;
            for i in powers.iter().skip(query[0] as usize).take((query[1] - query[0] + 1) as usize) {
                prod *= 1 << i;
                prod %= 1_000_000_007;
            }
            res.push(prod);
        }
        res
    }
}