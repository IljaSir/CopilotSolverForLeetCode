impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut i = 0;
        while i < arr.len() {
            let mut found = false;
            for piece in &pieces {
                if arr[i] == piece[0] {
                    found = true;
                    for j in 1..piece.len() {
                        if arr[i+j] != piece[j] {
                            return false;
                        }
                    }
                    i += piece.len();
                    break;
                }
            }
            if !found {
                return false;
            }
        }
        true
    }
}