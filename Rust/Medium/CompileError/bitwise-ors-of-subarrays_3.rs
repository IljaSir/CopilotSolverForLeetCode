impl Solution {
    pub fn subarray_bitwise_o_rs(arr: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        let mut cur = std::collections::HashSet::new();
        for &x in arr.iter() {
            let mut tmp = std::collections::HashSet::new();
            tmp.insert(x);
            for &y in cur.iter() {
                tmp.insert(x | y);
            }
            cur = tmp;
            set.extend(cur.iter());
        }
        set.len() as i32
    }
}