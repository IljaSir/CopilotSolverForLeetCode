impl Solution {
    pub fn path_in_zig_zag_tree(label: i32) -> Vec<i32> {
        
        let mut v = Vec::new();
        let mut l = label;
        let mut i = 0;
        while l > 0 {
            v.push(l);
            l /= 2;
            i += 1;
        }
        let mut j = 0;
        while j < i {
            let mut k = v[j];
            if j % 2 == 1 {
                k = 2_i32.pow(j as u32) + 2_i32.pow((j+1) as u32) - 1 - k;
            }
            v[j] = k;
            j += 1;
        }
        let mut j = 0;
        while j < i / 2 {
            let k = v[j];
            v[j] = v[i - j - 1];
            v[i - j - 1] = k;
            j += 1;
        }
        v
    }
}