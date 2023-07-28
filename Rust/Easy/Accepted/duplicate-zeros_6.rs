impl Solution {
    pub fn duplicate_zeros(arr: &mut Vec<i32>) {
        
        let mut i = 0;
        let mut j = 0;
        let mut v = vec![];
        while i < arr.len() {
            if arr[i] == 0 {
                v.push(0);
                v.push(0);
            } else {
                v.push(arr[i]);
            }
            i += 1;
        }
        while j < arr.len() {
            arr[j] = v[j];
            j += 1;
        }
    }
}