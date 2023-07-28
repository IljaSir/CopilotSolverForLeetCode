impl Solution {
    pub fn construct_array(n: i32, k: i32) -> Vec<i32> {
        

        let n = n as usize;
        let k = k as usize;
        let mut ret = vec![0; n];
        let mut l = 1;
        let mut r = n;
        for i in 0..n {
            if i < k {
                if i % 2 == 0 {
                    ret[i] = l;
                    l += 1;
                } else {
                    ret[i] = r;
                    r -= 1;
                }
            } else {
                ret[i] = l;
                l += 1;
            }
        }
        ret
    }
}