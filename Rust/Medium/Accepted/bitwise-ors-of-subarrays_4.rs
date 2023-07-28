impl Solution {
    pub fn subarray_bitwise_o_rs(arr: Vec<i32>) -> i32 {
        
        let mut s = std::collections::HashSet::new();
        let mut cur = std::collections::HashSet::new();
        for &x in arr.iter() {
            let mut next = std::collections::HashSet::new();
            next.insert(x);
            for &y in cur.iter() {
                next.insert(x | y);
            }
            cur = next;
            for &y in cur.iter() {
                s.insert(y);
            }
        }
        s.len() as i32
    }
}