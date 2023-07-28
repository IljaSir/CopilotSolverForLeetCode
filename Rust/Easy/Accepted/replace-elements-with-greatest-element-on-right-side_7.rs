impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        
        let mut v = arr.clone();
        let mut max = -1;
        for i in (0..v.len()).rev() {
            let t = v[i];
            v[i] = max;
            max = max.max(t);
        }
        v
    }
}