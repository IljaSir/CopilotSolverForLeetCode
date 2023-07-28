impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut m = arr[0];
        let mut c = 1;
        let mut v = vec![];
        for i in 1..arr.len() {
            if arr[i] == m {
                c += 1;
            } else {
                v.push((m, c));
                m = arr[i];
                c = 1;
            }
        }
        v.push((m, c));
        v.sort_by_key(|&(_, c)| c);
        let mut s = 0;
        let mut i = v.len() - 1;
        let mut r = 0;
        while s < arr.len() / 2 {
            s += v[i].1;
            i -= 1;
            r += 1;
        }
        r
    }
}