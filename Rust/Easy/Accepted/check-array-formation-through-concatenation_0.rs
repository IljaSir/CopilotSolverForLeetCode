impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut i = 0;
        while i < arr.len() {
            let mut j = 0;
            while j < pieces.len() {
                if pieces[j][0] == arr[i] {
                    break;
                }
                j += 1;
            }
            if j == pieces.len() {
                return false;
            }
            let mut k = 0;
            while k < pieces[j].len() {
                if pieces[j][k] != arr[i] {
                    return false;
                }
                i += 1;
                k += 1;
            }
        }
        true
    }
}