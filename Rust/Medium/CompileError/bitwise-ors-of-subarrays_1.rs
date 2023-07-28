impl Solution {
    pub fn subarray_bitwise_o_rs(arr: Vec<i32>) -> i32 {
        
        let mut res = std::collections::HashSet::new();
        let mut cur = std::collections::HashSet::new();
        cur.insert(0);
        for &x in &arr {
            let mut cur2 = std::collections::HashSet::new();
            cur2.insert(x);
            for &y in &cur {
                cur2.insert(x | y);
            }
            res.extend(cur2.iter());
            cur = cur2;
        }
        res.len() as i32
    }
}