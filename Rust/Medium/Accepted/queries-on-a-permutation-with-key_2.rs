impl Solution {
    pub fn process_queries(queries: Vec<i32>, m: i32) -> Vec<i32> {
        
        let mut p = Vec::new();
        for i in 1..=m {
            p.push(i);
        }
        let mut ans = Vec::new();
        for i in 0..queries.len() {
            let mut j = 0;
            while p[j] != queries[i] {
                j += 1;
            }
            ans.push(j as i32);
            let mut k = j;
            while k > 0 {
                p.swap(k, k-1);
                k -= 1;
            }
        }
        ans
    }
}