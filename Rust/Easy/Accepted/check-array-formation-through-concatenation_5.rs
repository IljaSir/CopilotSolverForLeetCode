impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut pieces = pieces;
        pieces.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut i = 0;
        while i < arr.len() {
            let mut j = 0;
            while j < pieces.len() {
                if arr[i] == pieces[j][0] {
                    for k in 0..pieces[j].len() {
                        if arr[i] != pieces[j][k] {
                            return false;
                        }
                        i += 1;
                    }
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