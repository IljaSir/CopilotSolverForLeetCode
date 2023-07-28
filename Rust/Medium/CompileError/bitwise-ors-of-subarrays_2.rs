impl Solution {
    pub fn subarray_bitwise_o_rs(arr: Vec<i32>) -> i32 {
        
        let mut res = std::collections::HashSet::new();
        let mut cur = std::collections::HashSet::new();
        for &x in arr.iter() {
            let mut nxt = std::collections::HashSet::new();
            nxt.insert(x);
            for &y in cur.iter() {
                nxt.insert(x | y);
            }
            cur = nxt;
            res.extend(cur.iter());
        }
        res.len() as i32
    }
}