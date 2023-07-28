impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut i = 0;
        while i < arr.len() {
            let mut j = 0;
            while j < pieces.len() {
                if arr[i] == pieces[j][0] {
                    for k in 0..pieces[j].len() {
                        if pieces[j][k] != arr[i + k] {
                            return false;
                        }
                    }
                    i += pieces[j].len();
                    break;
                }
                j += 1;
            }
            if j == pieces.len() {
                return false;
            }
        }
        true
    }
}