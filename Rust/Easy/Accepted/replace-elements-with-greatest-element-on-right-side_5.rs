impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        
        let mut a = arr;
        let mut max = -1;
        for i in (0..a.len()).rev() {
            let t = a[i];
            a[i] = max;
            max = max.max(t);
        }
        a
    }
}