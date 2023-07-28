impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut pieces = pieces;
        pieces.sort_by_key(|x| x[0]);
        let mut i = 0;
        while i < arr.len() {
            for piece in pieces.iter() {
                if arr[i] == piece[0] {
                    for v in piece.iter() {
                        if i >= arr.len() || arr[i] != *v {
                            return false;
                        }
                        i += 1;
                    }
                    break;
                }
            }
            if i < arr.len() && arr[i] != pieces[0][0] {
                return false;
            }
        }
        true
    }
}