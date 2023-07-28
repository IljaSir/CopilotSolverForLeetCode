impl Solution {
    pub fn path_in_zig_zag_tree(label: i32) -> Vec<i32> {
        
        let mut res = vec![label];
        let mut l = label;
        while l > 1 {
            l /= 2;
            res.push(l);
        }
        let mut i = 0;
        let mut j = res.len() - 1;
        while i < j {
            res[i] = (1 << (i + 1)) + (1 << i) - 1 - res[i];
            res[j] = (1 << (j + 1)) + (1 << j) - 1 - res[j];
            i += 1;
            j -= 1;
        }
        res
    }
}