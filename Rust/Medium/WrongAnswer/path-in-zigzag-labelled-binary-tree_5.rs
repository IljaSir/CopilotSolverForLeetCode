impl Solution {
    pub fn path_in_zig_zag_tree(label: i32) -> Vec<i32> {
        
        let mut res = vec![label];
        let mut i = label;
        while i > 1 {
            i = i / 2;
            i = i ^ (1 << i.trailing_zeros() - 1);
            res.push(i);
        }
        res.reverse();
        res
    }
}