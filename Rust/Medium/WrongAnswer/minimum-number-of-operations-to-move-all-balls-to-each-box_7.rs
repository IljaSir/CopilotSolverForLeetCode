impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut ans = vec![0; boxes.len()];
        let mut l = 0;
        let mut r = 0;
        let mut b = 0;
        for i in 0..boxes.len() {
            ans[i] += r;
            if boxes.as_bytes()[i] == b'1' {
                l += 1;
                r += l;
            }
        }
        l = 0;
        r = 0;
        b = 0;
        for i in (0..boxes.len()).rev() {
            ans[i] += r;
            if boxes.as_bytes()[i] == b'1' {
                l += 1;
                r += l;
            }
        }
        ans
    }
}