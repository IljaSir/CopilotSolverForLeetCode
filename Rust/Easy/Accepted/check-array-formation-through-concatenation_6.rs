impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut pieces = pieces;
        pieces.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut i = 0;
        while i < arr.len() {
            let mut j = 0;
            while j < pieces.len() {
                if pieces[j][0] == arr[i] {
                    let mut k = 0;
                    while k < pieces[j].len() {
                        if pieces[j][k] != arr[i + k] {
                            return false;
                        }
                        k += 1;
                    }
                    i += pieces[j].len();
                    j = pieces.len() + 1;
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