impl Solution {
    pub fn minimum_cost(cost: Vec<i32>) -> i32 {
        
        let mut c = cost;
        c.sort();
        let mut ans = 0;
        let mut i = 0;
        while i < c.len() {
            ans += c[i];
            i += 3;
        }
        ans
    }
}