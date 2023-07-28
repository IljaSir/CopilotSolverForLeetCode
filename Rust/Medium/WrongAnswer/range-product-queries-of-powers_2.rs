impl Solution {
    pub fn product_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut powers = vec![0; 32];
        let mut i = 0;
        let mut n = n;
        while n > 0 {
            if n & 1 == 1 {
                powers[i] = 1;
            }
            n >>= 1;
            i += 1;
        }
        let mut ans = vec![0; queries.len()];
        for (i, q) in queries.iter().enumerate() {
            let mut p = 1;
            for j in q[0]..=q[1] {
                p = (p * powers[j as usize]) % 1000000007;
            }
            ans[i] = p;
        }
        ans
    }
}