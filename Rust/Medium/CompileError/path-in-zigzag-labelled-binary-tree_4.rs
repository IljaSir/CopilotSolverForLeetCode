impl Solution {
    pub fn path_in_zig_zag_tree(label: i32) -> Vec<i32> {
        
        let mut res = vec![label];
        let mut n = label;
        let mut k = 1;
        while n > 1 {
            n >>= 1;
            k <<= 1;
            res.push(n);
        }
        let mut i = 1;
        let mut j = k;
        while i < j {
            res[i] = k - 1 - res[i] + k;
            i += 1;
            j -= 1;
        }
        res.reverse();
        res
    }
}