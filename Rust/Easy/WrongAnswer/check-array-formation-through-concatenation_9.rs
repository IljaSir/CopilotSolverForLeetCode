impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut all = vec![];
        for piece in pieces {
            all.extend(piece);
        }
        all == arr
    }
}