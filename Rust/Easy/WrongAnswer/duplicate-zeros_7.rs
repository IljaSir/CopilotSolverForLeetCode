impl Solution {
    pub fn duplicate_zeros(arr: &mut Vec<i32>) {
        
        let mut i = 0;
        let mut j = arr.len();
        while i < j {
            if arr[i] == 0 {
                j -= 1;
                arr.insert(i,0);
                arr.remove(arr.len() - 1);
                i += 2;
            } else {
                i += 1;
            }
        }
    }
}